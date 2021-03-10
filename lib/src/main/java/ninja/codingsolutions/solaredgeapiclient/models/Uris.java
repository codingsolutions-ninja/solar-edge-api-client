package ninja.codingsolutions.solaredgeapiclient.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.UrisImpl;

//TODO: evaluate converting these values to URI types instead of strings
/**
 * Additional URI Links
 */
@JsonDeserialize(as = UrisImpl.class)
public interface Uris {
    /**
     * Get the URI for the site image
     * @return {String} URI to the site image
     */
    String getSiteImage();

    /**
     * Get the URI for the data period
     * @return {String} URI to pull up data for the current period
     */
    String getDataPeriod();

    /**
     * Get the URI for site details
     * @return {String}  URI to pull up site details
     */
    String getDetails();

    /**
     * Get the URI for the site overview information
     * @return {String} URI to pull up site overview information
     */
    String getOverview();
}
