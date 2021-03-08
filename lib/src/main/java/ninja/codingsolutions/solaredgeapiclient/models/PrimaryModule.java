package ninja.codingsolutions.solaredgeapiclient.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.PrimaryModuleImpl;

@JsonDeserialize(as = PrimaryModuleImpl.class)
public interface PrimaryModule {
    String getManufacturerName();

    String getModelName();

    double getMaximumPower();

    double getTemperatureCoef();
}
