package ninja.codingsolutions.solaredgeapiclient.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.EnergyDetailsImpl;

import java.util.List;

/**
 * Energy details
 */
@JsonDeserialize(as = EnergyDetailsImpl.class)
public interface EnergyDetails {
    /**
     * Gets the time unit type associated with this set of energy details
     * @return {TimeUnitType} time unit type
     */
    TimeUnitType getTimeUnit();

    /**
     * Gets the power unit type associated with this set of energy details
     * @return {PowerUnitType} power unit type
     */
    PowerUnitType getUnit();

    /**
     * Get the list of detailed energy data associated with each meter on site
     * @return {java.util.List} list of detailed meter energy data
     */
    List<DetailedMeterEnergy> getMeters();
}
