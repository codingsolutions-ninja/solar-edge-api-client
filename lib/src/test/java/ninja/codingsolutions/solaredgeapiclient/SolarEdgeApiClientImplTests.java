package ninja.codingsolutions.solaredgeapiclient;

import ninja.codingsolutions.solaredgeapiclient.interfaces.SolarEdgeApiClient;
import ninja.codingsolutions.solaredgeapiclient.models.ApiResponse;
import ninja.codingsolutions.solaredgeapiclient.models.DetailedEnergyResponse;
import ninja.codingsolutions.solaredgeapiclient.models.DetailedMeterEnergy;
import ninja.codingsolutions.solaredgeapiclient.models.EnvironmentalBenefits;
import ninja.codingsolutions.solaredgeapiclient.models.EnvironmentalBenefitsResponse;
import ninja.codingsolutions.solaredgeapiclient.models.MeterType;
import ninja.codingsolutions.solaredgeapiclient.models.OverviewResponse;
import ninja.codingsolutions.solaredgeapiclient.models.PowerUnitType;
import ninja.codingsolutions.solaredgeapiclient.models.SiteDetailsResponse;
import ninja.codingsolutions.solaredgeapiclient.models.SupportedVersionsResponse;
import ninja.codingsolutions.solaredgeapiclient.models.TimeUnitType;
import ninja.codingsolutions.solaredgeapiclient.models.TimestampedValue;
import ninja.codingsolutions.solaredgeapiclient.models.VersionResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

class SolarEdgeApiClientImplTests {

    private static final String standardDetailedEnergyResponse = "{\n" +
            "    \"energyDetails\": {\n" +
            "        \"timeUnit\": \"DAY\",\n" +
            "        \"unit\": \"Wh\",\n" +
            "        \"meters\": [\n" +
            "            {\n" +
            "                \"type\": \"Production\",\n" +
            "                \"values\": [\n" +
            "                    {\n" +
            "                        \"date\": \"2021-02-01 00:00:00\",\n" +
            "                        \"value\": 49150.0\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"date\": \"2021-02-02 00:00:00\",\n" +
            "                        \"value\": 46183.0\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"date\": \"2021-02-03 00:00:00\",\n" +
            "                        \"value\": 46574.0\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"date\": \"2021-02-04 00:00:00\",\n" +
            "                        \"value\": 36582.0\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"date\": \"2021-02-05 00:00:00\",\n" +
            "                        \"value\": 19077.0\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"date\": \"2021-02-06 00:00:00\",\n" +
            "                        \"value\": 38874.0\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            {\n" +
            "                \"type\": \"Consumption\",\n" +
            "                \"values\": [\n" +
            "                    {\n" +
            "                        \"date\": \"2021-02-01 00:00:00\",\n" +
            "                        \"value\": 49150.0\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"date\": \"2021-02-02 00:00:00\",\n" +
            "                        \"value\": 46183.0\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"date\": \"2021-02-03 00:00:00\",\n" +
            "                        \"value\": 46574.0\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"date\": \"2021-02-04 00:00:00\",\n" +
            "                        \"value\": 36582.0\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"date\": \"2021-02-05 00:00:00\",\n" +
            "                        \"value\": 19077.0\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"date\": \"2021-02-06 00:00:00\",\n" +
            "                        \"value\": 38874.0\n" +
            "                    }\n" +
            "                ]\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "}";

    private static final String standardVersionJsonResponse = "{\n" +
            "    \"version\": {\n" +
            "        \"release\": \"1.0.0\"\n" +
            "    }\n" +
            "}";

    private static final String standardSupportedVersionsResponse = "{\n" +
            "    \"supported\": [\n" +
            "        {\n" +
            "            \"release\": \"1.0.0\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

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

    private static final String environmentalBenefitsResponse = "{\n" +
            "    \"envBenefits\": {\n" +
            "        \"gasEmissionSaved\": {\n" +
            "            \"units\": \"lb\",\n" +
            "            \"co2\": 34704.3,\n" +
            "            \"so2\": 25077.93,\n" +
            "            \"nox\": 7997.29\n" +
            "        },\n" +
            "        \"treesPlanted\": 262.22236560000005,\n" +
            "        \"lightBulbs\": 67915.664\n" +
            "    }\n" +
            "}";

    private HttpResponse<Object> mockResponse;
    private HttpClient mockClient;
    private SolarEdgeApiClient client;

    @SuppressWarnings("unchecked")
    @BeforeEach
    void setup(){
        mockClient = Mockito.mock(HttpClient.class);
        mockResponse = Mockito.mock(HttpResponse.class);
        CompletableFuture<HttpResponse<Object>> mockFuture = CompletableFuture.completedFuture(mockResponse);
        client = SolarEdgeClientFactory
                .builder()
                .apiKey("TEST")
                .httpClient(mockClient)
                .apiUrl("http://localhost/test")
                .build().buildClient();

        Mockito.when(mockClient.sendAsync(Mockito.any(), Mockito.any()))
                .thenReturn(mockFuture);
    }

    private void returnJson(String jsonStr) {
        Mockito.when(mockResponse.body()).thenReturn(jsonStr);
    }

    private void throwOnRequest(Throwable e) {
        Mockito.when(mockClient.sendAsync(Mockito.any(), Mockito.any())).thenReturn(CompletableFuture.failedFuture(e));
    }

    private void assertSiteInformationIsPresent(ApiResponse apiResponse) {
        Assertions.assertTrue(apiResponse.getSiteIds().isPresent() && apiResponse.getSiteIds().get().size() > 0);
    }

    private void assertSiteInformationIsNotPresent(ApiResponse apiResponse) {
        Assertions.assertFalse(apiResponse.getSiteIds().isPresent());
    }


    @Test
    void canGetSiteOverview() throws ExecutionException, InterruptedException {
        returnJson(standardOverviewJsonResponse);
        Future<OverviewResponse> response = client.getOverviewResponse(1111).toCompletableFuture();
        OverviewResponse resp = response.get();
        Assertions.assertNotNull(resp);
        assertSiteInformationIsPresent(resp);
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
        Future<SiteDetailsResponse> response = client.getSiteDetails(1111).toCompletableFuture();
        SiteDetailsResponse resp = response.get();
        Assertions.assertNotNull(resp);
        assertSiteInformationIsPresent(resp);
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

    @Test
    void canGetVersion() throws ExecutionException, InterruptedException {
        returnJson(standardVersionJsonResponse);
        Future<VersionResponse> response = client.getVersion().toCompletableFuture();
        VersionResponse version = response.get();
        Assertions.assertNotNull(version);
        assertSiteInformationIsNotPresent(version);
        Assertions.assertNotNull(version.getVersion());
        Assertions.assertEquals("1.0.0", version.getVersion().getRelease());

    }

    @Test
    void canGetSupportedVersions() throws ExecutionException, InterruptedException {
        returnJson(standardSupportedVersionsResponse);
        Future<SupportedVersionsResponse> response = client.getSupportedVersions().toCompletableFuture();
        SupportedVersionsResponse version = response.get();
        Assertions.assertNotNull(version);
        assertSiteInformationIsNotPresent(version);
        Assertions.assertNotNull(version.getSupported());
        Assertions.assertEquals(1, version.getSupported().size());
        Assertions.assertEquals("1.0.0", version.getSupported().get(0).getRelease());
    }

    @Test
    @SuppressWarnings("unchecked")
    void exceptionsBubble() throws ExecutionException, InterruptedException, ClassNotFoundException {
        throwOnRequest(new IOException("TEST Exception"));
        CompletableFuture<SupportedVersionsResponse> response = client.getSupportedVersions().toCompletableFuture();
        Class<? extends Exception> cls = (Class<? extends Exception>) Class.forName("java.lang.Exception");
        Assertions.assertThrows(cls, response::get);
        Assertions.assertTrue(response.isCompletedExceptionally());
    }

    @Test
    void canGetEnergyDetails() throws ExecutionException, InterruptedException {
        returnJson(standardDetailedEnergyResponse);
        Future<DetailedEnergyResponse> response = client.getDetailedEnergyReport(
                1111,
                List.of(MeterType.CONSUMPTION, MeterType.PRODUCTION),
                TimeUnitType.DAY,
                ZonedDateTime.now().minus(Duration.of(1, ChronoUnit.DAYS)),
                ZonedDateTime.now()
            ).toCompletableFuture();
        DetailedEnergyResponse detailedEnergyResponse = response.get();
        Assertions.assertNotNull(detailedEnergyResponse);
        assertSiteInformationIsPresent(detailedEnergyResponse);
        Assertions.assertNotNull(detailedEnergyResponse.getEnergyDetails());
        Assertions.assertEquals(PowerUnitType.WH, detailedEnergyResponse.getEnergyDetails().getUnit());
        Assertions.assertEquals(TimeUnitType.DAY, detailedEnergyResponse.getEnergyDetails().getTimeUnit());
        Assertions.assertEquals(2, detailedEnergyResponse.getEnergyDetails().getMeters().size());
        for(DetailedMeterEnergy meterEnergy : detailedEnergyResponse.getEnergyDetails().getMeters()){
            Assertions.assertNotNull(meterEnergy);
            Assertions.assertNotNull(meterEnergy.getType());
            Assertions.assertTrue(meterEnergy.getValues().size() > 0);
            for(TimestampedValue energyValue : meterEnergy.getValues()) {
                Assertions.assertTrue(energyValue.getValue() > 0);
                Assertions.assertTrue(energyValue.getDate().after(new Date(0)));
            }
        }
    }

    @Test
    void canGetEnvironmentalImpacts() throws ExecutionException, InterruptedException {
        returnJson(environmentalBenefitsResponse);
        Future<EnvironmentalBenefitsResponse> response = client.getEnvironmentalBenefits(1111).toCompletableFuture();
        EnvironmentalBenefitsResponse envResponse = response.get();
        EnvironmentalBenefits benefits = envResponse.getEnvBenefits();
        Assertions.assertNotNull(benefits);
        Assertions.assertEquals(262.22236560000005, benefits.getTreesPlanted());
        Assertions.assertEquals(67915.664, benefits.getLightBulbs());
        EnvironmentalBenefits.GasEmissionsSaved savedEmissions = benefits.getGasEmissionSaved();
        Assertions.assertNotNull(benefits.getGasEmissionSaved());
        Assertions.assertEquals(34704.3, savedEmissions.getCo2());
        Assertions.assertEquals(25077.93, savedEmissions.getSo2());
        Assertions.assertEquals(7997.29, savedEmissions.getNox());
        Assertions.assertEquals(EnvironmentalBenefits.EmissionUnitType.LB, savedEmissions.getUnits());
    }
}
