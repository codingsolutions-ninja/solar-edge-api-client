package ninja.codingsolutions.solaredgeapiclient.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.DetailedMeterEnergyImpl;

@JsonDeserialize(as = DetailedMeterEnergyImpl.class)
public interface DetailedMeterEnergy {
    MeterType getType();
    java.util.List<TimestampedValue> getValues();
}
