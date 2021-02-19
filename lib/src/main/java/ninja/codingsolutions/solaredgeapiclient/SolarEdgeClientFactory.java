package ninja.codingsolutions.solaredgeapiclient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import ninja.codingsolutions.solaredgeapiclient.interfaces.SolarEdgeApiClient;

import java.net.http.HttpClient;

/**
 * Factory to build a SolarEdgeApiClient instances
 */
@Builder
@AllArgsConstructor
public final class SolarEdgeClientFactory {
    private final String apiUrl;
    private final String apiKey;
    private final HttpClient httpClient;

    /**
     * Given the specified parameters provided, construct a api client
     * @return newly constructed API client instance
     */
    public SolarEdgeApiClient buildClient() {
        return new SolarEdgeApiClientImpl(httpClient, apiUrl, apiKey);
    }
}