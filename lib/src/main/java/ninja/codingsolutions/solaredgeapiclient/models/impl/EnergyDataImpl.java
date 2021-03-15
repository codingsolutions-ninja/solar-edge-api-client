package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.EnergyData;

/**
 * Energy data in kWh
 */
@Data
@SuperBuilder
@Jacksonized
public class EnergyDataImpl implements EnergyData {
    private double energy;
}
