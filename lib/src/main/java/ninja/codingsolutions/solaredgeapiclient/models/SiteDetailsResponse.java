package ninja.codingsolutions.solaredgeapiclient.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

/**
 * Detailed site response from API
 */
@Data
@Builder
@Jacksonized
public class SiteDetailsResponse {
    private Details details;
}
