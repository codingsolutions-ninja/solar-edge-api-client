package ninja.codingsolutions.solaredgeapiclient.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class DetailedEnergyResponse {
    private final EnergyDetails energyDetails;
}
