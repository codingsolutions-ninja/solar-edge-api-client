package ninja.codingsolutions.solaredgeapiclient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import ninja.codingsolutions.solaredgeapiclient.interfaces.SolarEdgeApiClient;

@Builder
@AllArgsConstructor
public final class SolarEdgeClientFactory {
    private final String apiUrl;
    private final String apiKey;

    public SolarEdgeApiClient buildClient() {
        return null;
    }
}