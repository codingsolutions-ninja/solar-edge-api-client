package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.Overview;
import ninja.codingsolutions.solaredgeapiclient.models.OverviewResponse;

/**
 * Overview response from API
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Jacksonized
@SuperBuilder
public class OverviewResponseImpl extends ApiResponseImpl implements OverviewResponse {
    private Overview overview;

    @Override
    public Object deepCopy() {
        return super.deepCopy(builder()
                .overview(OverviewImpl.builder()
                        .lifeTimeData(LifeTimeDataImpl.builder()
                                .revenue(this.getOverview().getLifeTimeData().getRevenue())
                                .energy(this.getOverview().getLifeTimeData().getEnergy())
                                .build())
                        .lastUpdateTime(this.getOverview().getLastUpdateTime())
                        .lastYearData(EnergyDataImpl.builder()
                                .energy(this.getOverview().getLastYearData().getEnergy())
                                .build())
                        .lastMonthData(EnergyDataImpl.builder()
                                .energy(this.getOverview().getLastMonthData().getEnergy())
                                .build())
                        .lastDayData(EnergyDataImpl.builder()
                                .energy(this.getOverview().getLastDayData().getEnergy())
                                .build())
                        .measuredBy(this.getOverview().getMeasuredBy())
                        .currentPower(this.getOverview().getCurrentPower())
                        .build())
                .build());
    }
}
