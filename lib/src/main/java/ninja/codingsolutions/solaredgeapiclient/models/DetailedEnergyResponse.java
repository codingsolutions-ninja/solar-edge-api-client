package ninja.codingsolutions.solaredgeapiclient.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.DetailedEnergyResponseImpl;

/**
 * Response from SolarEdge API containing detailed energy information
 * over a period of time
 */
@JsonDeserialize(as = DetailedEnergyResponseImpl.class)
public interface DetailedEnergyResponse extends ApiResponse {
    /**
     * EnergyDetails, contains time unit type, power unit type, and data points of energy data
     * over a period of time
     * @return {EnergyDetails} detailed energy data from the time specified in the initial query
     */
    EnergyDetails getEnergyDetails();
}
