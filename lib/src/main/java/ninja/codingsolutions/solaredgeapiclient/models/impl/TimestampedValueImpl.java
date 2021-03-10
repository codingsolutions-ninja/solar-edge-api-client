package ninja.codingsolutions.solaredgeapiclient.models.impl;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.TimestampedValue;

import java.util.Date;

/**
 * Implementation of {TimestampedValue}
 */
@Builder
@Jacksonized
@Data
public class TimestampedValueImpl implements TimestampedValue {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private final Date date;
    private final double value;

}
