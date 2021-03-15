package ninja.codingsolutions.solaredgeapiclient.models.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.PublicSettings;

/**
 * Setting if this site is visible to other users on
 * when using the API
 */
@Builder
@Data
@Jacksonized
public class PublicSettingsImpl implements PublicSettings {
    @JsonProperty("isPublic")
    private boolean isPublic;
}
