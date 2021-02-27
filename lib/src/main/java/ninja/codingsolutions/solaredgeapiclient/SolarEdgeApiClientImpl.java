package ninja.codingsolutions.solaredgeapiclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import ninja.codingsolutions.solaredgeapiclient.interfaces.SolarEdgeApiClient;
import ninja.codingsolutions.solaredgeapiclient.models.*;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.CompletableFuture;
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

    private static <T> T getMessageFromBody(String jsonStr, Class<T> cls) throws IOException {
        return mapper.readValue(jsonStr, cls);
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

    private CompletableFuture<?> getObjectFromResponse(String url, HttpClient client, Class<?> cl){
        var ref = new Object() {
            CompletableFuture<?> cResp = null;
        };
        ref.cResp = getResponseFromApi(url, client)
                .thenApplyAsync(resp -> {
                    try {
                        return getMessageFromBody(resp, cl);
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
        return (CompletableFuture<SiteDetailsResponse>)getObjectFromResponse(url, client, SiteDetailsResponse.class);
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
        return (CompletableFuture<OverviewResponse>)getObjectFromResponse(url, client, OverviewResponse.class);
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
        return (CompletableFuture<VersionResponse>)getObjectFromResponse(url, client, VersionResponse.class);
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
        return (CompletableFuture<SupportedVersionsResponse>)getObjectFromResponse(url, client, SupportedVersionsResponse.class);
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
        return (CompletableFuture<DetailedEnergyResponse>)getObjectFromResponse(url, client, DetailedEnergyResponse.class);
    }
}
