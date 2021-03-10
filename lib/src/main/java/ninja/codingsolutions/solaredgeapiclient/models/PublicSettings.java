package ninja.codingsolutions.solaredgeapiclient.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.PublicSettingsImpl;

/**
 * Public settings
 */
@JsonDeserialize(as = PublicSettingsImpl.class)
public interface PublicSettings {
    /**
     * get whether or not the site information is available to the public
     * @return {boolean} true if the site is available to the public, false otherwise
     */
    boolean isPublic();
}
