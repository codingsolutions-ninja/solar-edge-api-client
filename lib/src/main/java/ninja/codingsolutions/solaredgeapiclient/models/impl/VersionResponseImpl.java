package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.Version;
import ninja.codingsolutions.solaredgeapiclient.models.VersionResponse;

@Data
@Builder
@Jacksonized
public class VersionResponseImpl implements VersionResponse {
    private final Version version;
}
