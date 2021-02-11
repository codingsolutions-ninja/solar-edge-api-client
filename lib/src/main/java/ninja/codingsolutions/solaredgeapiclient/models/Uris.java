package ninja.codingsolutions.solaredgeapiclient.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Builder
@Data
@Jacksonized
public class Uris
{
    @JsonProperty("SITE_IMAGE")
    private String siteImage;
    @JsonProperty("DATA_PERIOD")
    private String dataPeriod;
    @JsonProperty("DETAILS")
    private String details;
    @JsonProperty("OVERVIEW")
    private String overview;
}
