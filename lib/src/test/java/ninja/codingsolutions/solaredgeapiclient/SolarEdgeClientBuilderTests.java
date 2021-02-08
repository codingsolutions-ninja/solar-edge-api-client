package ninja.codingsolutions.solaredgeapiclient;


import ninja.codingsolutions.solaredgeapiclient.interfaces.SolarEdgeApiClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolarEdgeClientBuilderTests {

    @Test
    public void builderReturnsNull(){
        SolarEdgeClientFactory factory = SolarEdgeClientFactory
                .builder()
                .apiKey("TEST")
                .apiUrl("TEST")
                .build();
        SolarEdgeApiClient client = factory.buildClient();
        Assertions.assertNull(client);
    }
}