package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.EnvironmentalBenefits;

@Data
@SuperBuilder
@Jacksonized
public class EnvironmentBenefitsImpl implements EnvironmentalBenefits {
    private final double treesPlanted;
    private final double lightBulbs;
    private final GasEmissionsSaved gasEmissionSaved;
}
