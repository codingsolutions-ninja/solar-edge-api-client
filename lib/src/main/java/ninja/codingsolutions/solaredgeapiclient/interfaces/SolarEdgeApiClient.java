package ninja.codingsolutions.solaredgeapiclient.interfaces;

import ninja.codingsolutions.solaredgeapiclient.models.DetailedEnergyResponse;
import ninja.codingsolutions.solaredgeapiclient.models.EnvironmentalBenefitsResponse;
import ninja.codingsolutions.solaredgeapiclient.models.MeterType;
import ninja.codingsolutions.solaredgeapiclient.models.OverviewResponse;
import ninja.codingsolutions.solaredgeapiclient.models.SiteDetailsResponse;
import ninja.codingsolutions.solaredgeapiclient.models.SupportedVersionsResponse;
import ninja.codingsolutions.solaredgeapiclient.models.TimeUnitType;
import ninja.codingsolutions.solaredgeapiclient.models.VersionResponse;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.concurrent.CompletionStage;

/**
 * Interface defining the interactions available for the client
 * to enact
 */
public interface SolarEdgeApiClient {
    /**
     * Fetch the site details from the API
     * @param siteId integer id of the site
     * @return future that resolve with the site details associated with the provided site id
     */
    CompletionStage<SiteDetailsResponse> getSiteDetails(int siteId);

    /**
     * Fetch a high level summary/overview of the site
     * @param siteId integer id of the site
     * @return future that resolves with the overview response
     */
    CompletionStage<OverviewResponse> getOverviewResponse(int siteId);


    /**
     * Get the current version of the API
     * @return response object detailing the current version of the API server
     */
    CompletionStage<VersionResponse> getVersion();


    /**
     * Get the list of supported versions by the API server
     * @return response object detailing the list of versions that the API server supports
     */
    CompletionStage<SupportedVersionsResponse> getSupportedVersions();

    /**
     * Fetches the estimated environmental benefits impact information associated with
     * the targeted site id
     * @param siteId targeted site id
     * @return response object containing the estimated environmental impacts
     */
    CompletionStage<EnvironmentalBenefitsResponse> getEnvironmentalBenefits(int siteId);

    /**
     * Fetches a detailed energy report as recorded by the specified meter types, at the targeted
     * site, within the time window, and in the specified time resolution. The times should be in the same time zone
     * as the site.
     * @param siteId integer id of the site id
     * @param meters which meters to include the response
     * @param timeUnitType what time resolution is desired in the response
     * @param startTime the start time of the data window
     * @param endTime the end time of the data window
     * @return a response containing the energy details as specified by the query parameters
     */
    CompletionStage<DetailedEnergyResponse> getDetailedEnergyReport(
            int siteId,
            List<MeterType> meters,
            TimeUnitType timeUnitType,
            ZonedDateTime startTime,
            ZonedDateTime endTime
            );


}
