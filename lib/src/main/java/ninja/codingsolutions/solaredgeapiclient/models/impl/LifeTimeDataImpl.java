package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.LifeTimeData;

/**
 * Lifetime value of energy in kWh and
 * revenue in USD
 */
@Data
@SuperBuilder
@Jacksonized
@EqualsAndHashCode(callSuper=false)
public class LifeTimeDataImpl extends EnergyDataImpl implements LifeTimeData {
    private double revenue;
}
