package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ninja.codingsolutions.solaredgeapiclient.models.LifeTimeData;
import ninja.codingsolutions.solaredgeapiclient.models.impl.EnergyDataImpl;

/**
 * Lifetime value of energy in kWh and
 * revenue in USD
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class LifeTimeDataImpl extends EnergyDataImpl implements LifeTimeData {
    private double revenue;
}
