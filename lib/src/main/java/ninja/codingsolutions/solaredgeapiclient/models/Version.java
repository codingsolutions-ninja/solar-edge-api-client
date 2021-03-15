package ninja.codingsolutions.solaredgeapiclient.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.VersionImpl;

/**
 * Version information
 */
@JsonDeserialize(as = VersionImpl.class)
public interface Version extends BaseModel {
    /**
     * Get the version release string
     * @return {String} release version string
     */
    String getRelease();
}
