package ninja.codingsolutions.solaredgeapiclient.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.LifeTimeDataImpl;

@JsonDeserialize(as = LifeTimeDataImpl.class)
public interface LifeTimeData extends EnergyData {
    double getRevenue();
}
