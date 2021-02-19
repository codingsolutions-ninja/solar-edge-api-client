package ninja.codingsolutions.solaredgeapiclient.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Lifetime value of energy in kWh and
 * revenue in USD
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class LifeTimeData extends EnergyData {
    private double revenue;
}
