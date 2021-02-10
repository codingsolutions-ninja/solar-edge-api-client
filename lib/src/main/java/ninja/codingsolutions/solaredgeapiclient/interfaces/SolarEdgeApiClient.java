package ninja.codingsolutions.solaredgeapiclient.interfaces;

import ninja.codingsolutions.solaredgeapiclient.models.OverviewResponse;
import ninja.codingsolutions.solaredgeapiclient.models.SiteDetailsResponse;

import java.util.concurrent.Future;

public interface SolarEdgeApiClient {
    /**
     * Fetch the site details from the API
     * @param siteId integer id of the site
     * @return future that resolve with the site details associated with the provided site id
     */
    Future<SiteDetailsResponse> getSiteDetails(int siteId);

    /**
     * Fetch a high level summary/overview of the site
     * @param siteId integer id of the site
     * @return future that resolves with the overview response
     */
    Future<OverviewResponse> getOverviewResponse(int siteId);
}
