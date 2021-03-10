package ninja.codingsolutions.solaredgeapiclient.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.LocationImpl;

/**
 * Site Location Information
 */
@JsonDeserialize(as = LocationImpl.class)
public interface Location {
    /**
     * Get the country the site is located in
     * @return {String} Country
     */
    String getCountry();

    /**
     * Get the state the site is located in
     * @return {String} State
     */
    String getState();

    /**
     * Get the city the site is located in
     * @return {String} City
     */
    String getCity();

    /**
     * Get the street address of the site
     * @return {String} Address
     */
    String getAddress();

    /**
     * Get the second address line of the site if available
     * @return {String} Address 2
     */
    String getAddress2();

    /**
     * Get the zip of the site
     * @return {String} Zip Code
     */
    String getZip();

    /**
     * Get the time zone of the site
     * @return {String} time zone
     */
    String getTimeZone();

    /**
     * Get short country code of the site
     * @return {String} Country Code
     */
    String getCountryCode();

    /**
     * Get the state code of the site
     * @return {String} State Code
     */
    String getStateCode();
}
