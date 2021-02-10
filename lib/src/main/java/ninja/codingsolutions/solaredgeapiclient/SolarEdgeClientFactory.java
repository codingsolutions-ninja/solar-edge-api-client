package ninja.codingsolutions.solaredgeapiclient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import ninja.codingsolutions.solaredgeapiclient.interfaces.SolarEdgeApiClient;

import java.net.http.HttpClient;

@Builder
@AllArgsConstructor
public final class SolarEdgeClientFactory {
    private final String apiUrl;
    private final String apiKey;
    private final HttpClient httpClient;

    public SolarEdgeApiClient buildClient() {
        return new SolarEdgeApiClientImpl(httpClient, apiUrl, apiKey);
    }
}