package ninja.codingsolutions.solaredgeapiclient.models;

public interface EnergyDetails {
    TimeUnitType getTimeUnit();

    PowerUnitType getUnit();

    java.util.List<DetailedMeterEnergy> getMeters();
}
