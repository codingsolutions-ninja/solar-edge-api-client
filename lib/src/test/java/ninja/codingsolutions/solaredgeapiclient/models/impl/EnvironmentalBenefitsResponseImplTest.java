package ninja.codingsolutions.solaredgeapiclient.models.impl;

import ninja.codingsolutions.solaredgeapiclient.interfaces.DeepCopyable;
import ninja.codingsolutions.solaredgeapiclient.models.EnvironmentalBenefits;

public class EnvironmentalBenefitsResponseImplTest extends BaseModelTest {
    @Override
    protected DeepCopyable buildRandomObject() {
        return EnvironmentalBenefitsResponseImpl.builder()
                .envBenefits(EnvironmentBenefitsImpl.builder()
                        .lightBulbs(random.nextDouble())
                        .treesPlanted(random.nextDouble())
                        .gasEmissionSaved(GasEmissionsSavedImpl.builder()
                                .co2(random.nextDouble())
                                .so2(random.nextDouble())
                                .nox(random.nextDouble())
                                .units(EnvironmentalBenefits.EmissionUnitType.LB)
                                .build())
                        .build()).build();
    }

    @Override
    protected Class<?> getDeserializiableClass() {
        return EnvironmentalBenefitsResponseImpl.class;
    }
}
