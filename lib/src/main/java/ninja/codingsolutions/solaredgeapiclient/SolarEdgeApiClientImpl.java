package ninja.codingsolutions.solaredgeapiclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import ninja.codingsolutions.solaredgeapiclient.interfaces.SolarEdgeApiClient;
import ninja.codingsolutions.solaredgeapiclient.models.OverviewResponse;
import ninja.codingsolutions.solaredgeapiclient.models.SiteDetailsResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@AllArgsConstructor
public class SolarEdgeApiClientImpl implements SolarEdgeApiClient {
    private final HttpClient client;
    private final String endPoint;
    private final String apiKey;

    private static final ObjectMapper mapper = new ObjectMapper();

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

    private Future<?> getObjectFromResponse(String url, HttpClient client, Class<?> cl){
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
    public Future<SiteDetailsResponse> getSiteDetails(int siteId) {
        String url = String.format("%s/site/%s/details?api_key=%s", endPoint, siteId, apiKey);
        return (Future<SiteDetailsResponse>)getObjectFromResponse(url, client, SiteDetailsResponse.class);
    }

    /**
     * Fetch a high level summary/overview of the site
     *
     * @param siteId integer id of the site
     * @return future that resolves with the overview response
     */
    @SuppressWarnings("unchecked")
    @Override
    public Future<OverviewResponse> getOverviewResponse(int siteId) {
        String url = String.format("%s/site/%s/overview?api_key=%s", endPoint, siteId, apiKey);
        return (Future<OverviewResponse>)getObjectFromResponse(url, client, OverviewResponse.class);
    }
}
