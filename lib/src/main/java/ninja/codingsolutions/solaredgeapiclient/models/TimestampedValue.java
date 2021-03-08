package ninja.codingsolutions.solaredgeapiclient.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.TimestampedValueImpl;

@JsonDeserialize(as = TimestampedValueImpl.class)
public interface TimestampedValue {
    java.util.Date getDate();

    double getValue();
}
