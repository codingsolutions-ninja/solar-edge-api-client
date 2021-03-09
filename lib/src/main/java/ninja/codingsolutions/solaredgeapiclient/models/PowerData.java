package ninja.codingsolutions.solaredgeapiclient.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.PowerDataImpl;

@JsonDeserialize(as = PowerDataImpl.class)
public interface PowerData {
    double getPower();
}
