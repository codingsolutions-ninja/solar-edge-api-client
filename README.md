# solar-edge-api-client

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/37f762e312fa4bc2b21cb4073673a501)](https://app.codacy.com/gh/akboyd88/solar-edge-api-client?utm_source=github.com&utm_medium=referral&utm_content=akboyd88/solar-edge-api-client&utm_campaign=Badge_Grade)

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