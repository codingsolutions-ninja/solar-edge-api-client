package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.Overview;
import ninja.codingsolutions.solaredgeapiclient.models.OverviewResponse;

/**
 * Overview response from API
 */
@Data
@Jacksonized
@Builder
public class OverviewResponseImpl implements OverviewResponse {
    private Overview overview;
}
