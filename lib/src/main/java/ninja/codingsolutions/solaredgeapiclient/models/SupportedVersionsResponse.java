package ninja.codingsolutions.solaredgeapiclient.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.SupportedVersionsResponseImpl;

/**
 * API response to a supported version list request
 */
@JsonDeserialize(as = SupportedVersionsResponseImpl.class)
public interface SupportedVersionsResponse {
    /**
     * get the list of supported versions by the API
     * @return {java.util.List} list of versions supported by the API
     */
    java.util.List<Version> getSupported();
}
