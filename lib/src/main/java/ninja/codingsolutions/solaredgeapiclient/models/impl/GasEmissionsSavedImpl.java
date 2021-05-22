package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.EnvironmentalBenefits;

@Data
@SuperBuilder
@Jacksonized
public class GasEmissionsSavedImpl implements EnvironmentalBenefits.GasEmissionsSaved {
    private final EnvironmentalBenefits.EmissionUnitType units;
    private final double co2;
    private final double nox;
    private final double so2;
}
