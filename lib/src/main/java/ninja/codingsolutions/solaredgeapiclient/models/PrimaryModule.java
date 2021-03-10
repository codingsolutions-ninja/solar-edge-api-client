package ninja.codingsolutions.solaredgeapiclient.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.PrimaryModuleImpl;

/**
 * Primary module information for the site
 */
@JsonDeserialize(as = PrimaryModuleImpl.class)
public interface PrimaryModule {
    /**
     * Manufacturer of the primary module (invertor)
     * @return {String} manufacturer of primary module
     */
    String getManufacturerName();

    /**
     * Get the model name of the primary module
     * @return {String} primary module model name
     */
    String getModelName();

    /**
     * Get the max power of the primary module
     * @return {double} max power of the primary module in kilowatt hours
     */
    double getMaximumPower();

    /**
     * Get the temperature coefficient of the primary module
     * @return {double} temperature coefficient of the primary module
     */
    double getTemperatureCoef();
}
