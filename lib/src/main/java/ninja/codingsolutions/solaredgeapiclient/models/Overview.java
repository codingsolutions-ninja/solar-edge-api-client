package ninja.codingsolutions.solaredgeapiclient.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.OverviewImpl;

/**
 * Site Overview
 */
@JsonDeserialize(as = OverviewImpl.class)
public interface Overview {
    /**
     * Get the last update time of the site, is in timezone of the site
     * @return {java.util.Date} Date of last update
     */
    java.util.Date getLastUpdateTime();

    /**
     * get the lifetime date of the site
     * @return {LifeTimeDate} site lifetime date
     */
    LifeTimeData getLifeTimeData();

    /**
     * Get the summary of last years energy data in quarters
     * @return {EnergyData} last years energy data
     */
    EnergyData getLastYearData();

    /**
     * Get last months energy data per day
     * @return {EnergyData} last months energy data
     */
    EnergyData getLastMonthData();

    /**
     * Get the energy data for the last day
     * @return {EnergyData} last days energy data
     */
    EnergyData getLastDayData();

    /**
     * Get the last reported instantaneous power generation value in kilowatt hours
     * @return {EnergyData} current power generation
     */
    PowerData getCurrentPower();

    /**
     * Get the string of the measuring meter
     * @return {String} measured by meter
     */
    String getMeasuredBy();
}
