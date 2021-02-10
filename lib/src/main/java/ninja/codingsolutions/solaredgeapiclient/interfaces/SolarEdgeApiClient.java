package ninja.codingsolutions.solaredgeapiclient.interfaces;

import ninja.codingsolutions.solaredgeapiclient.models.SiteDetailsResponse;

import java.util.concurrent.Future;

public interface SolarEdgeApiClient {
    /**
     * Fetch the site details from the API
     * @param siteId integer id of the site
     * @return future that resolve with the site details associated with the provided site id
     */
    Future<SiteDetailsResponse> getSiteDetails(int siteId);
}
