package ninja.codingsolutions.solaredgeapiclient.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.LocationImpl;

@JsonDeserialize(as = LocationImpl.class)
public interface Location {
    String getCountry();
    String getState();
    String getCity();
    String getAddress();
    String getAddress2();
    String getZip();
    String getTimeZone();
    String getCountryCode();
    String getStateCode();
}
