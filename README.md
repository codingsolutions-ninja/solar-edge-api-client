# solar-edge-api-client

![Codacy grade](https://img.shields.io/codacy/grade/1626e3d2cbb14a1dad742e43b343dbc5?style=for-the-badge) ![Codecov](https://img.shields.io/codecov/c/gh/akboyd88/solar-edge-api-client?style=for-the-badge) ![GitHub](https://img.shields.io/github/license/akboyd88/solar-edge-api-client?style=for-the-badge) ![GitHub tag (latest SemVer)](https://img.shields.io/github/v/tag/akboyd88/solar-edge-api-client?style=for-the-badge) ![Maven Central](https://img.shields.io/maven-central/v/ninja.codingsolutions/solar-edge-api-client?style=for-the-badge)
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

### Command Support Table

| Command | Supported | Batch/Multi Site Support
| :---: | :---: | :---:
| Get Current Version | :heavy_check_mark: | :x: 
| Get Supported Versions | :heavy_check_mark: | :x:
| Get Site Overview | :heavy_check_mark: | :x:
| Detailed Energy Query | :heavy_check_mark: | :x: 
| Get Site List | :x: | N/A
| Get Power Flow | :x: | :x:
| 


