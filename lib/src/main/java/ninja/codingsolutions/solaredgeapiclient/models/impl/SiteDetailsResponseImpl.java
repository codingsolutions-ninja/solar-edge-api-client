package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.Details;
import ninja.codingsolutions.solaredgeapiclient.models.SiteDetailsResponse;

/**
 * Detailed site response from API
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Jacksonized
public class SiteDetailsResponseImpl extends ApiResponseImpl implements SiteDetailsResponse {
    private Details details;
}
