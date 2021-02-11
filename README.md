# solar-edge-api-client

## Usage 

```java
import ninja.codingsolutions.solaredgeapiclient.interfaces.SolarEdgeApiClient;

SolarEdgeClientFactory factory = SolarEdgeClientFactory
    .builder()
    .apiKey("YOUR_API_KEY")
    .apiUrl("https://monitoringapi.solaredge.com")
    .build();

SolarEdgeApiClient client = factory.buildClient();

CompletableFuture<OverviewResponse> future = client.getOverviewResponse(YOUR_SITE_NUMBER);

future.thenApplyAsync(resp ->{
    System.out.println(String.format("Your solar panels are generating %s w/h of power", resp.getOverview()
        .getCurrentPower()
        .getPower();))
});
```