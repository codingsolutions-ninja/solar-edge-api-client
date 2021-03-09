package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.DetailedEnergyResponse;
import ninja.codingsolutions.solaredgeapiclient.models.EnergyDetails;

@Data
@Builder
@Jacksonized
public class DetailedEnergyResponseImpl implements DetailedEnergyResponse {
    private final EnergyDetails energyDetails;
}
