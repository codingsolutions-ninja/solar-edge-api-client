package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.Details;
import ninja.codingsolutions.solaredgeapiclient.models.SiteDetailsResponse;

/**
 * Detailed site response from API
 */
@Data
@Builder
@Jacksonized
public class SiteDetailsResponseImpl implements SiteDetailsResponse {
    private Details details;
}
