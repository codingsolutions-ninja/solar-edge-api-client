package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.DetailedEnergyResponse;
import ninja.codingsolutions.solaredgeapiclient.models.EnergyDetails;

/**
 * Implementation of {DetailedEnergyResponse}
 */
@Data
@Builder
@Jacksonized
public class DetailedEnergyResponseImpl implements DetailedEnergyResponse {
    private final EnergyDetails energyDetails;
}
