package ninja.codingsolutions.solaredgeapiclient.models.impl;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.deserializers.CustomDateDeserializer;
import ninja.codingsolutions.solaredgeapiclient.models.TimestampedValue;
import ninja.codingsolutions.solaredgeapiclient.serializers.CustomDateSerializer;

import java.util.Date;

/**
 * Implementation of {TimestampedValue}
 */
@Builder
@Jacksonized
@Data
public class TimestampedValueImpl implements TimestampedValue {
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonSerialize(using = CustomDateSerializer.class)
    private final Date date;
    private final double value;

}
