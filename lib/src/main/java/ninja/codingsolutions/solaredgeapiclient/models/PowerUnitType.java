package ninja.codingsolutions.solaredgeapiclient.models;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Unit type for power
 */
public enum PowerUnitType {
    /**
     * Watt Hours
     */
    WH("Wh", (short)0);

    private final String type;
    private final short shortVal;

    PowerUnitType(String type, short val) {
        this.type = type;
        this.shortVal = val;

    }

    /**
     * Get the string representation of the enum, for example Wh
     * @return {String} string representation of the enum
     */
    @JsonValue
    public String getType() {
        return this.type;
    }

    /**
     * Get the numerical representation of the enum value, values start at 0
     * @return {Short} get the numerical representation of the enum value
     */
    public short getValue() {
        return this.shortVal;
    }
}
