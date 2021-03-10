package ninja.codingsolutions.solaredgeapiclient.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.OverviewResponseImpl;

/**
 * API response to a request for overview data
 */
@JsonDeserialize(as = OverviewResponseImpl.class)
public interface OverviewResponse {
    /**
     * get the overview data
     * @return {Overview} overview data
     */
    Overview getOverview();
}
