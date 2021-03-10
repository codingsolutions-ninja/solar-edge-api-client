package ninja.codingsolutions.solaredgeapiclient.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.SiteDetailsResponseImpl;

/**
 * API response to a site details requests
 */
@JsonDeserialize(as = SiteDetailsResponseImpl.class)
public interface SiteDetailsResponse {
    /**
     * Get the site details
     * @return {Details} site details
     */
    Details getDetails();
}
