package ninja.codingsolutions.solaredgeapiclient.models;

public interface Overview {
    java.util.Date getLastUpdateTime();

    LifeTimeData getLifeTimeData();

    EnergyData getLastYearData();

    EnergyData getLastMonthData();

    EnergyData getLastDayData();

    PowerData getCurrentPower();

    String getMeasuredBy();
}
