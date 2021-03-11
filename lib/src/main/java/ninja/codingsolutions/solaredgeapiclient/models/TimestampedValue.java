package ninja.codingsolutions.solaredgeapiclient.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.TimestampedValueImpl;

import java.util.Date;

/**
 * Timestamped value, typically for energy production or consumption
 */
@JsonDeserialize(as = TimestampedValueImpl.class)
public interface TimestampedValue {
    /**
     * Date of energy measurement
     * @return {java.util.Date} date associated with measurement in site timezone
     */
    Date getDate();

    /**
     * Get the measurement value
     * @return {double} measured value
     */
    double getValue();
}
