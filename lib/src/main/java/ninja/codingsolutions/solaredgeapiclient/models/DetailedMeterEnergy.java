package ninja.codingsolutions.solaredgeapiclient.models;

public interface DetailedMeterEnergy {
    MeterType getType();
    java.util.List<TimestampedValue> getValues();
}
