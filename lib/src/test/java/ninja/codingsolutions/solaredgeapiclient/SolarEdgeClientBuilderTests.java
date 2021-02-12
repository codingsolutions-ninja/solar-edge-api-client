package ninja.codingsolutions.solaredgeapiclient;


import ninja.codingsolutions.solaredgeapiclient.interfaces.SolarEdgeApiClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolarEdgeClientBuilderTests {

    @Test
    void builderReturnsClient(){
        SolarEdgeClientFactory factory = SolarEdgeClientFactory
                .builder()
                .apiKey("TEST")
                .apiUrl("TEST")
                .build();
        SolarEdgeApiClient client = factory.buildClient();
        Assertions.assertNotNull(client);
    }
}