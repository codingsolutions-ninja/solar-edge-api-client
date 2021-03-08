package ninja.codingsolutions.solaredgeapiclient.models;

public interface PrimaryModule {
    String getManufacturerName();

    String getModelName();

    double getMaximumPower();

    double getTemperatureCoef();
}
