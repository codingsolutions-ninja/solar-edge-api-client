package ninja.codingsolutions.solaredgeapiclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import ninja.codingsolutions.solaredgeapiclient.interfaces.SolarEdgeApiClient;
import ninja.codingsolutions.solaredgeapiclient.models.ApiResponse;
import ninja.codingsolutions.solaredgeapiclient.models.DetailedEnergyResponse;
import ninja.codingsolutions.solaredgeapiclient.models.EnvironmentalBenefits;
import ninja.codingsolutions.solaredgeapiclient.models.EnvironmentalBenefitsResponse;
import ninja.codingsolutions.solaredgeapiclient.models.MeterType;
import ninja.codingsolutions.solaredgeapiclient.models.OverviewResponse;
import ninja.codingsolutions.solaredgeapiclient.models.SiteDetailsResponse;
import ninja.codingsolutions.solaredgeapiclient.models.SupportedVersionsResponse;
import ninja.codingsolutions.solaredgeapiclient.models.TimeUnitType;
import ninja.codingsolutions.solaredgeapiclient.models.VersionResponse;
import ninja.codingsolutions.solaredgeapiclient.models.impl.DetailedEnergyResponseImpl;
import ninja.codingsolutions.solaredgeapiclient.models.impl.EnvironmentalBenefitsResponseImpl;
import ninja.codingsolutions.solaredgeapiclient.models.impl.OverviewResponseImpl;
import ninja.codingsolutions.solaredgeapiclient.models.impl.SiteDetailsResponseImpl;
import ninja.codingsolutions.solaredgeapiclient.models.impl.SupportedVersionsResponseImpl;
import ninja.codingsolutions.solaredgeapiclient.models.impl.VersionResponseImpl;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

/**
 * Implementation of the solar edge api client interface.
 * Requires a provided HttpClient, endPoint URI and api key value
 */
@AllArgsConstructor
public class SolarEdgeApiClientImpl implements SolarEdgeApiClient {
    private final HttpClient client;
    private final String endPoint;
    private final String apiKey;

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final String TIME_FORMAT_STRING = "yyyy-MM-dd hh:mm:ss";


    private static final String ENERGY_DETAILS_URL = "%s/site/%s/energyDetails?meters=%s&timeUnit=%s&startTime=%s&endTime=%s&api_key=%s";

    private static <T extends ApiResponse> T getMessageFromBody(String jsonStr, Class<T> cls) throws IOException {
        return mapper.readValue(jsonStr, cls);
    }

    private static List<Integer> buildSiteIdListFromSingleValue(Integer siteId) {
        List<Integer> siteIds = new ArrayList<>();
        siteIds.add(siteId);
        return siteIds;
    }


    private static CompletableFuture<String> getResponseFromApi(String url, HttpClient client){
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();
        return client
                .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApplyAsync(HttpResponse::body);
    }

    private static String encode(String val) {
        return URLEncoder.encode(val, StandardCharsets.UTF_8);
    }

    private CompletableFuture<? extends ApiResponse>getObjectFromResponse(String url, HttpClient client, Class<? extends ApiResponse> cl, List<Integer> siteIds){
        var ref = new Object() {
            CompletableFuture<? extends ApiResponse> cResp = null;
        };
        ref.cResp = getResponseFromApi(url, client)
                .thenApplyAsync(resp -> {
                    try {
                        ApiResponse apiResp = getMessageFromBody(resp, cl);
                        apiResp.setSiteIds(siteIds);
                        return apiResp;
                    } catch (IOException e) {
                        ref.cResp.completeExceptionally(e);
                        return null;
                    }
                });
        return ref.cResp;
    }


    @SuppressWarnings("unchecked")
    @Override
    public CompletableFuture<SiteDetailsResponse> getSiteDetails(int siteId) {
        String url = String.format("%s/site/%s/details?api_key=%s", endPoint, siteId, apiKey);
        return (CompletableFuture<SiteDetailsResponse>)getObjectFromResponse(url, client, SiteDetailsResponseImpl.class, buildSiteIdListFromSingleValue(siteId));
    }

    /**
     * Fetch a high level summary/overview of the site
     *
     * @param siteId integer id of the site
     * @return future that resolves with the overview response
     */
    @SuppressWarnings("unchecked")
    @Override
    public CompletableFuture<OverviewResponse> getOverviewResponse(int siteId) {
        String url = String.format("%s/site/%s/overview?api_key=%s", endPoint, siteId, apiKey);
        return (CompletableFuture<OverviewResponse>)getObjectFromResponse(url, client, OverviewResponseImpl.class, buildSiteIdListFromSingleValue(siteId));
    }

    /**
     * Get the current version of the API
     *
     * @return response object detailing the current version of the API server
     */
    @SuppressWarnings("unchecked")
    @Override
    public CompletableFuture<VersionResponse> getVersion() {
        String url = String.format("%s/version/current?api_key=%s", endPoint, apiKey);
        return (CompletableFuture<VersionResponse>)getObjectFromResponse(url, client, VersionResponseImpl.class, null);
    }

    /**
     * Get the list of supported versions by the API server
     *
     * @return response object detailing the list of versions that the API server supports
     */
    @SuppressWarnings("unchecked")
    @Override
    public CompletableFuture<SupportedVersionsResponse> getSupportedVersions() {
        String url = String.format("%s/version/supported?api_key=%s", endPoint, apiKey);
        return (CompletableFuture<SupportedVersionsResponse>)getObjectFromResponse(url, client, SupportedVersionsResponseImpl.class, null);
    }

    /**
     * Fetches the estimated environmental benefits impact information associated with
     * the targeted site id
     *
     * @param siteId targeted site id
     * @return response object containing the estimated environmental impacts
     */
    @SuppressWarnings("unchecked")
    @Override
    public CompletionStage<EnvironmentalBenefitsResponse> getEnvironmentalBenefits(int siteId) {
        String url = String.format("%s/site/%s/envBenefits?systemUnits=Imperial&api_key=%s", endPoint, siteId, apiKey);
        return (CompletableFuture<EnvironmentalBenefitsResponse>)getObjectFromResponse(url,
                client, EnvironmentalBenefitsResponseImpl.class, buildSiteIdListFromSingleValue(siteId));
    }

    /**
     * Fetches a detailed energy report as recorded by the specified meter types, at the targeted
     * site, within the time window, and in the specified time resolution. The times should be in the
     * the same zone as the site.
     *
     * @param siteId       integer id of the site id
     * @param meters       which meters to include the response
     * @param timeUnitType what time resolution is desired in the response
     * @param startTime    the start time of the data window
     * @param endTime      the end time of the data window
     * @return a response containing the energy details as specified by the query parameters
     */
    @Override
    @SuppressWarnings("unchecked")
    public CompletableFuture<DetailedEnergyResponse> getDetailedEnergyReport(
            int siteId,
            List<MeterType> meters,
            TimeUnitType timeUnitType,
            ZonedDateTime startTime,
            ZonedDateTime endTime) {
        //API uses this time format. yyyy-MM-dd hh:mm:ss
        //Time zones are localized at the site level

        String startTimeString = encode(DateTimeFormatter.ofPattern(TIME_FORMAT_STRING).format(startTime));
        String endTimeString = encode(DateTimeFormatter.ofPattern(TIME_FORMAT_STRING).format(endTime));

        String url = String.format(ENERGY_DETAILS_URL,
                endPoint,
                siteId,
                meters.stream().map(Enum::toString).collect(Collectors.joining(",")),
                timeUnitType,
                startTimeString,
                endTimeString,
                apiKey);
        return (CompletableFuture<DetailedEnergyResponse>)getObjectFromResponse(url, client, DetailedEnergyResponseImpl.class, buildSiteIdListFromSingleValue(siteId));
    }
}
