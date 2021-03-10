package ninja.codingsolutions.solaredgeapiclient.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Meter type, this can be a production meter or consumption meter
 */
public enum MeterType {
    /**
     * Meter that measures how much energy has been produced
     */
    @JsonProperty("Production")
    PRODUCTION("Production", (short)0),
    /**
     * Meter that measures how much energy has been consumed
     */
    @JsonProperty("Consumption")
    CONSUMPTION("Consumption", (short)1);

    private final String type;
    private final short value;

    MeterType(String type, short val) {
        this.type = type;
        this.value = val;
    }

    /**
     * Get the type of the meter type, this could be Production, Consumption
     * @return {String} string value of the enum type
     */
    @JsonValue
    public String getType() {
        return this.type;
    }

    /**
     * Get the enum value of the meter type, PRODUCTION = 0, CONSUMPTION = 1
     * @return {short} numerical representation of the enum type
     */
    public short getValue() {
        return this.value;
    }
}
