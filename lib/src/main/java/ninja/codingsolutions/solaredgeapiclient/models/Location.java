package ninja.codingsolutions.solaredgeapiclient.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Builder
@Data
@Jacksonized
public class Location {
    private String country;
    private String state;
    private String city;
    private String address;
    private String address2;
    private String zip;
    private String timeZone;
    private String countryCode;
    private String stateCode;
}