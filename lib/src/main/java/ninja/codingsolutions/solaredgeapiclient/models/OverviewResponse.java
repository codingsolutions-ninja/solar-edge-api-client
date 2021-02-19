package ninja.codingsolutions.solaredgeapiclient.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

/**
 * Overview response from API
 */
@Data
@Jacksonized
@Builder
public class OverviewResponse {
    private Overview overview;
}
