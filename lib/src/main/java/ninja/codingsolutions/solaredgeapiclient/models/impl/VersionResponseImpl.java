package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.Version;
import ninja.codingsolutions.solaredgeapiclient.models.VersionResponse;

/**
 * Implementation of {VersionResponse}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Jacksonized
public class VersionResponseImpl extends ApiResponseImpl implements VersionResponse {
    private final Version version;
}
