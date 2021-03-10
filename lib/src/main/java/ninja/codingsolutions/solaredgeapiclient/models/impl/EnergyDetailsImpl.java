package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.DetailedMeterEnergy;
import ninja.codingsolutions.solaredgeapiclient.models.EnergyDetails;
import ninja.codingsolutions.solaredgeapiclient.models.PowerUnitType;
import ninja.codingsolutions.solaredgeapiclient.models.TimeUnitType;

import java.util.List;

/**
 * Implementation of {EnergyDetails}
 */
@Data
@Builder
@Jacksonized
public class EnergyDetailsImpl implements EnergyDetails {
    private final TimeUnitType timeUnit;
    private final PowerUnitType unit;
    private final List<DetailedMeterEnergy> meters;
}
