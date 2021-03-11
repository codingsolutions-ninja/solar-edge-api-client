package ninja.codingsolutions.solaredgeapiclient.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.SupportedVersionsResponseImpl;

import java.util.List;

/**
 * API response to a supported version list request
 */
@JsonDeserialize(as = SupportedVersionsResponseImpl.class)
public interface SupportedVersionsResponse extends ApiResponse {
    /**
     * get the list of supported versions by the API
     * @return {java.util.List} list of versions supported by the API
     */
    List<Version> getSupported();
}
