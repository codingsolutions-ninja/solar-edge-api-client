package ninja.codingsolutions.solaredgeapiclient.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.LifeTimeDataImpl;

/**
 * Get the life time data of the site including revenue
 */
@JsonDeserialize(as = LifeTimeDataImpl.class)
public interface LifeTimeData extends EnergyData {
    /**
     * Get an estimate of site revenue
     * @return {double} site revenue
     */
    double getRevenue();
}
