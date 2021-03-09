package ninja.codingsolutions.solaredgeapiclient.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.EnergyDataImpl;

@JsonDeserialize(as = EnergyDataImpl.class)
public interface EnergyData {
    double getEnergy();
}
