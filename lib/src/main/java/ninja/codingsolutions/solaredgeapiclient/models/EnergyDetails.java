package ninja.codingsolutions.solaredgeapiclient.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Builder
@Jacksonized
public class EnergyDetails {
    private final TimeUnitType timeUnit;
    private final PowerUnitType unit;
    private final List<DetailedMeterEnergy> meters;
}
