package ninja.codingsolutions.solaredgeapiclient.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.EnergyDetailsImpl;

@JsonDeserialize(as = EnergyDetailsImpl.class)
public interface EnergyDetails {
    TimeUnitType getTimeUnit();

    PowerUnitType getUnit();

    java.util.List<DetailedMeterEnergy> getMeters();
}
