package ninja.codingsolutions.solaredgeapiclient.models.impl;

import ninja.codingsolutions.solaredgeapiclient.interfaces.DeepCopyable;
import ninja.codingsolutions.solaredgeapiclient.models.MeterType;
import ninja.codingsolutions.solaredgeapiclient.models.PowerUnitType;
import ninja.codingsolutions.solaredgeapiclient.models.TimeUnitType;

import java.util.Date;
import java.util.List;

public class DetailedEnergyResponseImplTests extends BaseModelTest {
    @Override
    protected DeepCopyable buildRandomObject() {
        return DetailedEnergyResponseImpl.builder()
                .siteIds(List.of(random.nextInt()))
                .energyDetails(EnergyDetailsImpl.builder()
                        .timeUnit(TimeUnitType.WEEK)
                        .unit(PowerUnitType.WH)
                        .meters(List.of(DetailedMeterEnergyImpl.builder().type(MeterType.CONSUMPTION)
                        .values(List.of(TimestampedValueImpl.builder()
                                .value(random.nextDouble())
                                .date(new Date()).build()))
                        .build())).build())
                .build();
    }

    @Override
    protected Class<?> getDeserializiableClass() {
        return DetailedEnergyResponseImpl.class;
    }
}
