package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.EnvironmentalBenefits;
import ninja.codingsolutions.solaredgeapiclient.models.EnvironmentalBenefitsResponse;

@lombok.EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@Jacksonized
public class EnvironmentalBenefitsResponseImpl extends ApiResponseImpl implements EnvironmentalBenefitsResponse {
    private final EnvironmentalBenefits envBenefits;

    /**
     * Create and return a deep copy of the current object
     *
     * @return {Object} deep copy of current object
     */
    @Override
    public Object deepCopy() {
        return super.deepCopy(EnvironmentalBenefitsResponseImpl.builder()
                .envBenefits(EnvironmentBenefitsImpl.builder()
                        .lightBulbs(getEnvBenefits().getLightBulbs())
                        .treesPlanted(getEnvBenefits().getTreesPlanted())
                        .gasEmissionSaved(GasEmissionsSavedImpl.builder()
                                .co2(envBenefits.getGasEmissionSaved().getCo2())
                                .so2(envBenefits.getGasEmissionSaved().getSo2())
                                .nox(envBenefits.getGasEmissionSaved().getNox())
                                .units(envBenefits.getGasEmissionSaved().getUnits())
                                .build())
                        .build()).build());
    }
}
