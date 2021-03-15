package ninja.codingsolutions.solaredgeapiclient.models.impl;

import ninja.codingsolutions.solaredgeapiclient.interfaces.DeepCopyable;

import java.util.Date;
import java.util.List;

public class OverviewResponseImplTests extends BaseModelTest {
    @Override
    protected DeepCopyable buildRandomObject() {
        return OverviewResponseImpl.builder()
                .siteIds(List.of(random.nextInt()))
                .overview(OverviewImpl.builder()
                        .currentPower(PowerDataImpl.builder().power(random.nextDouble()).build())
                        .measuredBy("METER")
                        .lastDayData(EnergyDataImpl.builder()
                            .energy(random.nextDouble()).build())
                        .lastMonthData(EnergyDataImpl.builder()
                            .energy(random.nextDouble()).build())
                        .lastYearData(EnergyDataImpl.builder()
                            .energy(random.nextDouble()).build())
                        .lastUpdateTime(new Date())
                        .lifeTimeData(LifeTimeDataImpl.builder()
                            .revenue(random.nextDouble())
                            .energy(random.nextDouble()).build())
                        .build())
                .build();
    }

    @Override
    protected Class<?> getDeserializiableClass() {
        return OverviewResponseImpl.class;
    }
}
