package ninja.codingsolutions.solaredgeapiclient.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.OverviewImpl;

@JsonDeserialize(as = OverviewImpl.class)
public interface Overview {
    java.util.Date getLastUpdateTime();

    LifeTimeData getLifeTimeData();

    EnergyData getLastYearData();

    EnergyData getLastMonthData();

    EnergyData getLastDayData();

    PowerData getCurrentPower();

    String getMeasuredBy();
}
