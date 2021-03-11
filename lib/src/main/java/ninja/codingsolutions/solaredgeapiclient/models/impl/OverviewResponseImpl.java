package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.Overview;
import ninja.codingsolutions.solaredgeapiclient.models.OverviewResponse;

/**
 * Overview response from API
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Jacksonized
@Builder
public class OverviewResponseImpl extends ApiResponseImpl implements OverviewResponse {
    private Overview overview;
}
