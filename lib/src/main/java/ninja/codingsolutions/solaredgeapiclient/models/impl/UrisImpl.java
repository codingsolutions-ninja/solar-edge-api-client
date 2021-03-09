package ninja.codingsolutions.solaredgeapiclient.models.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.Uris;

/**
 * Link information to supplemental information
 * such as site image, data period, details, and overview
 */
@Builder
@Data
@Jacksonized
public class UrisImpl implements Uris {
    @JsonProperty("SITE_IMAGE")
    private String siteImage;
    @JsonProperty("DATA_PERIOD")
    private String dataPeriod;
    @JsonProperty("DETAILS")
    private String details;
    @JsonProperty("OVERVIEW")
    private String overview;
}
