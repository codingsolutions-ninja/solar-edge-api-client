package ninja.codingsolutions.solaredgeapiclient.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PowerUnitType {
    WH("Wh", (short)0);

    private final String type;
    private final short shortVal;

    PowerUnitType(String type, short val) {
        this.type = type;
        this.shortVal = val;

    }

    @JsonValue
    public String getType() {
        return this.type;
    }

    public short getValue() {
        return this.shortVal;
    }
}
