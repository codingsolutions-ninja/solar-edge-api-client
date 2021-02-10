package ninja.codingsolutions.solaredgeapiclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import ninja.codingsolutions.solaredgeapiclient.interfaces.SolarEdgeApiClient;
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

    private static <T> T getMessageFromBody(HttpResponse<String> resp, Class<T> cls) throws IOException {
        return mapper.readValue(resp.body(), cls);
    }

    public Future<SiteDetailsResponse> getSiteDetails(int siteId) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(String.format("%s/site/%s/details?api_key=%s", endPoint, siteId, apiKey)))
                .build();
        //TODO: find a better way
        var ref = new Object() {
            CompletableFuture<SiteDetailsResponse> cResp = null;
        };
        ref.cResp = client
                .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApplyAsync(resp -> {
                    try {
                        return getMessageFromBody(resp, SiteDetailsResponse.class);
                    } catch (IOException e) {
                        ref.cResp.completeExceptionally(e);
                        return null;
                    }
                });
        return ref.cResp;
    }
}
