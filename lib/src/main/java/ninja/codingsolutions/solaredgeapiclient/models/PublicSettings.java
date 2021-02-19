package ninja.codingsolutions.solaredgeapiclient.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

/**
 * Setting if this site is visible to other users on
 * when using the API
 */
@Builder
@Data
@Jacksonized
public class PublicSettings
{
    private boolean isPublic;
}
