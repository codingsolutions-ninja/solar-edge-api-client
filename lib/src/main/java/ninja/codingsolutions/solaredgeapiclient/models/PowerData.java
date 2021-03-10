package ninja.codingsolutions.solaredgeapiclient.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.PowerDataImpl;

/**
 * Power data
 */
@JsonDeserialize(as = PowerDataImpl.class)
public interface PowerData {
    /**
     * get the power data
     * @return {double} power data
     */
    double getPower();
}
