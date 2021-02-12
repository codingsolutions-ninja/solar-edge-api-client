package ninja.codingsolutions.solaredgeapiclient;

import ninja.codingsolutions.solaredgeapiclient.interfaces.SolarEdgeApiClient;
import ninja.codingsolutions.solaredgeapiclient.models.OverviewResponse;
import ninja.codingsolutions.solaredgeapiclient.models.SiteDetailsResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

class SolarEdgeApiClientImplTests {

    private static final String standardOverviewJsonResponse = "{\n" +
            "    \"overview\": {\n" +
            "        \"lastUpdateTime\": \"2021-02-09 21:25:49\",\n" +
            "        \"lifeTimeData\": {\n" +
            "            \"energy\": 1.8905078E7,\n" +
            "            \"revenue\": 1306.1078\n" +
            "        },\n" +
            "        \"lastYearData\": {\n" +
            "            \"energy\": 1340462.0\n" +
            "        },\n" +
            "        \"lastMonthData\": {\n" +
            "            \"energy\": 345071.0\n" +
            "        },\n" +
            "        \"lastDayData\": {\n" +
            "            \"energy\": 33054.0\n" +
            "        },\n" +
            "        \"currentPower\": {\n" +
            "            \"power\": 0.0\n" +
            "        },\n" +
            "        \"measuredBy\": \"INVERTER\"\n" +
            "    }\n" +
            "}";

    private static final String standardDetailJsonResponse = "{\n" +
            "    \"details\": {\n" +
            "        \"id\": 1,\n" +
            "        \"name\": \"John Smith\",\n" +
            "        \"accountId\": 5,\n" +
            "        \"status\": \"Active\",\n" +
            "        \"peakPower\": 8.68,\n" +
            "        \"lastUpdateTime\": \"2021-02-09\",\n" +
            "        \"currency\": \"USD\",\n" +
            "        \"installationDate\": \"2019-07-31\",\n" +
            "        \"ptoDate\": null,\n" +
            "        \"notes\": \"\",\n" +
            "        \"type\": \"Optimizers & Inverters\",\n" +
            "        \"location\": {\n" +
            "            \"country\": \"United States\",\n" +
            "            \"state\": \"Test\",\n" +
            "            \"city\": \"Test\",\n" +
            "            \"address\": \"Test\",\n" +
            "            \"address2\": \"\",\n" +
            "            \"zip\": \"11111\",\n" +
            "            \"timeZone\": \"America/Chicago\",\n" +
            "            \"countryCode\": \"US\",\n" +
            "            \"stateCode\": \"TT\"\n" +
            "        },\n" +
            "        \"primaryModule\": {\n" +
            "            \"manufacturerName\": \"Mission Solar\",\n" +
            "            \"modelName\": \"MSE310SQ8T\",\n" +
            "            \"maximumPower\": 310.0,\n" +
            "            \"temperatureCoef\": -0.43\n" +
            "        },\n" +
            "        \"uris\": {\n" +
            "            \"SITE_IMAGE\": \"/site/1/siteImage/test.JPG\",\n" +
            "            \"DATA_PERIOD\": \"/site/1/dataPeriod\",\n" +
            "            \"DETAILS\": \"/site/1/details\",\n" +
            "            \"OVERVIEW\": \"/site/1/overview\"\n" +
            "        },\n" +
            "        \"publicSettings\": {\n" +
            "            \"isPublic\": false\n" +
            "        }\n" +
            "    }\n" +
            "}";

    private HttpClient mockClient;
    private HttpResponse<Object> mockResponse;
    private CompletableFuture<HttpResponse<Object>> mockFuture;
    private SolarEdgeApiClient client;

    @SuppressWarnings("unchecked")
    @BeforeEach
    void setup(){
        mockClient = Mockito.mock(HttpClient.class);
        mockResponse = Mockito.mock(HttpResponse.class);
        mockFuture = CompletableFuture.completedFuture(mockResponse);
        client = SolarEdgeClientFactory
                .builder()
                .apiKey("TEST")
                .httpClient(mockClient)
                .apiUrl("http://localhost/test")
                .build().buildClient();

        Mockito.when(mockClient.sendAsync(Mockito.any(), Mockito.any()))
                .thenReturn(mockFuture);
    }

    void returnJson(String jsonStr) {
        Mockito.when(mockResponse.body()).thenReturn(jsonStr);
    }

    @Test
    void canGetSiteOverview() throws ExecutionException, InterruptedException {
        returnJson(standardOverviewJsonResponse);
        Future<OverviewResponse> response = client.getOverviewResponse(1111);
        OverviewResponse resp = response.get();
        Assertions.assertNotNull(resp);
        Assertions.assertNotNull(resp.getOverview());
        Assertions.assertNotNull(resp.getOverview().getLifeTimeData());
        Assertions.assertNotNull(resp.getOverview().getLastDayData());
        Assertions.assertNotNull(resp.getOverview().getLastMonthData());
        Assertions.assertNotNull(resp.getOverview().getLastYearData());
        Assertions.assertNotNull(resp.getOverview().getCurrentPower());
        Assertions.assertEquals(1.8905078E7, resp.getOverview().getLifeTimeData().getEnergy());
        Assertions.assertEquals(1306.1078, resp.getOverview().getLifeTimeData().getRevenue());
        Assertions.assertEquals(1340462.0, resp.getOverview().getLastYearData().getEnergy());
        Assertions.assertEquals(345071.0, resp.getOverview().getLastMonthData().getEnergy());
        Assertions.assertEquals(33054.0, resp.getOverview().getLastDayData().getEnergy());
        Assertions.assertEquals(0.0, resp.getOverview().getCurrentPower().getPower());
        Assertions.assertEquals("INVERTER", resp.getOverview().getMeasuredBy());
    }

    /**
     * Basic test for fetching site details and parsing from json to usable POJO
     * @throws ExecutionException thrown if future execution throws an exception
     * @throws InterruptedException thrown if waiting on future is interrupted
     */
    @Test
    void canGetSiteDetails() throws ExecutionException, InterruptedException, ParseException {
        returnJson(standardDetailJsonResponse);
        Future<SiteDetailsResponse> response = client.getSiteDetails(1111);
        SiteDetailsResponse resp = response.get();
        Assertions.assertNotNull(resp);
        Assertions.assertNotNull(resp.getDetails());
        Assertions.assertEquals(1, resp.getDetails().getId());
        Assertions.assertEquals("John Smith", resp.getDetails().getName());
        Assertions.assertEquals(5, resp.getDetails().getAccountId());
        Assertions.assertEquals("Active", resp.getDetails().getStatus());
        Assertions.assertEquals(8.68, resp.getDetails().getPeakPower());
        Assertions.assertEquals("USD", resp.getDetails().getCurrency());
        Assertions.assertNull(resp.getDetails().getPtoDate());
        Assertions.assertEquals("", resp.getDetails().getNotes());
        Assertions.assertEquals("Optimizers & Inverters", resp.getDetails().getType());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

        Assertions.assertEquals(formatter.parse("2019-07-31").toInstant(), resp.getDetails().getInstallationDate().toInstant());
        Assertions.assertEquals(formatter.parse("2021-02-09").toInstant(), resp.getDetails().getLastUpdateTime().toInstant());


        //assert child objects are not null
        Assertions.assertNotNull(resp.getDetails().getPublicSettings());
        Assertions.assertNotNull(resp.getDetails().getPrimaryModule());
        Assertions.assertNotNull(resp.getDetails().getLocation());
        Assertions.assertNotNull(resp.getDetails().getUris());

        //location
        Assertions.assertEquals("Test", resp.getDetails().getLocation().getAddress());
        Assertions.assertEquals("Test", resp.getDetails().getLocation().getCity());
        Assertions.assertEquals("United States", resp.getDetails().getLocation().getCountry());
        Assertions.assertEquals("Test", resp.getDetails().getLocation().getState());
        Assertions.assertEquals("America/Chicago", resp.getDetails().getLocation().getTimeZone());
        Assertions.assertEquals("11111", resp.getDetails().getLocation().getZip());
        Assertions.assertEquals("TT", resp.getDetails().getLocation().getStateCode());
        Assertions.assertEquals("", resp.getDetails().getLocation().getAddress2());

        //uris
        Assertions.assertEquals("/site/1/siteImage/test.JPG", resp.getDetails().getUris().getSiteImage());
        Assertions.assertEquals("/site/1/dataPeriod", resp.getDetails().getUris().getDataPeriod());
        Assertions.assertEquals("/site/1/details", resp.getDetails().getUris().getDetails());
        Assertions.assertEquals("/site/1/overview", resp.getDetails().getUris().getOverview());

        //primary module
        Assertions.assertEquals("Mission Solar", resp.getDetails().getPrimaryModule().getManufacturerName());
        Assertions.assertEquals("MSE310SQ8T", resp.getDetails().getPrimaryModule().getModelName());
        Assertions.assertEquals(310.0, resp.getDetails().getPrimaryModule().getMaximumPower());
        Assertions.assertEquals( -0.43, resp.getDetails().getPrimaryModule().getTemperatureCoef());
    }
}
