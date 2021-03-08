package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.PrimaryModule;

/**
 * Primary module (inverter) metrics
 */
@Builder
@Data
@Jacksonized
public class PrimaryModuleImpl implements PrimaryModule {
    private String manufacturerName;
    private String modelName;
    private double maximumPower;
    private double temperatureCoef;
}
