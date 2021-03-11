package ninja.codingsolutions.solaredgeapiclient.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.VersionResponseImpl;

/**
 * The API response for a current version request
 */
@JsonDeserialize(as = VersionResponseImpl.class)
public interface VersionResponse extends ApiResponse {
    /**
     * Get the current version of the solar edge API
     * @return {Version} current version
     */
    Version getVersion();
}
