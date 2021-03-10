package ninja.codingsolutions.solaredgeapiclient.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.EnergyDataImpl;

/**
 * Wrapper of energy data
 */
@JsonDeserialize(as = EnergyDataImpl.class)
public interface EnergyData {
    /**
     * Energy information, could be energy produced or consumed depending on context, is in kilowatt hours
     * @return {double} energy
     */
    double getEnergy();
}
