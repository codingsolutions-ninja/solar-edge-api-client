package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Data;
import ninja.codingsolutions.solaredgeapiclient.models.EnergyData;

/**
 * Energy data in kWh
 */
@Data
public class EnergyDataImpl implements EnergyData {
    private double energy;
}
