package ninja.codingsolutions.solaredgeapiclient.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.DetailedMeterEnergyImpl;

import java.util.List;

/**
 * Detailed meter data from a solar edge site over a period of time scoped to a meter type
 */
@JsonDeserialize(as = DetailedMeterEnergyImpl.class)
public interface DetailedMeterEnergy {
    /**
     * What type of meter the associated data is coming from, this indicates if the energy was consumed
     * or produced.
     * @return {MeterType} type of meter this data is associated with
     */
    MeterType getType();

    /**
     * Timestamped values of energy used or produced
     * @return {java.util.List} A list of time stamped values with associated energy values
     */
    List<TimestampedValue> getValues();
}
