package ninja.codingsolutions.solaredgeapiclient.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.DetailsImpl;

import java.util.Date;

/**
 * SolarEdge site details containing, id, name, account id etc
 */
@JsonDeserialize(as = DetailsImpl.class)
public interface Details {
    /**
     * Gets the unique site id value identifying this site
     * @return {int} site id
     */
    int getId();

    /**
     * Gets the human readable display name of the site
     * @return {String} site name
     */
    String getName();

    /**
     * Gets the account id associated with the site, accounts can have multiple sites
     * @return {int} account id
     */
    int getAccountId();

    /**
     * Get the status of the site
     * @return {String} status of the site
     */
    String getStatus();

    /**
     * Get the peak power capabilities of the site in kilowatt hours
     * @return {double} site peak power
     */
    double getPeakPower();

    /**
     * Get the last time the site information was updated by the solar edge inverter, this is typically
     * on 15 minute intervals
     * @return {java.util.Date} last update time of the site
     */
    Date getLastUpdateTime();

    /**
     * Get an estimate of the total value of the energy produced by the site
     * @return {String} string containing the numerical representation of currency estimated by site production values
     * including the currency type
     */
    String getCurrency();

    /**
     * Gets the site installation date
     * @return {java.util.Date} The date on which the site was installed, production start dates may vary
     * based on locality approval
     */
    Date getInstallationDate();

    /**
     * TODO: get more information on this value
     * @return {String} get the PTO date for the site
     */
    String getPtoDate();

    /**
     * Get any notes associated with the site
     * @return {String} site notes
     */
    String getNotes();

    /**
     * Get the site type
     * @return {String} site type
     */
    String getType();

    /**
     * Get the location of the site, this in the form of address, city etc.
     * @return {Location} site location
     */
    Location getLocation();

    /**
     * Get the information on the primary  module at the site
     * @return {PrimaryModule} site primary module
     */
    PrimaryModule getPrimaryModule();

    /**
     * Get URIs that have additional site information such as a site photo.
     * @return {Uris} URIs to additional information
     */
    Uris getUris();

    /**
     * Get the public setting of this site, indicating if it's viewable by everyone with API access.
     * @return {PublicSettings} public settings
     */
    PublicSettings getPublicSettings();
}
