package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.SupportedVersionsResponse;
import ninja.codingsolutions.solaredgeapiclient.models.Version;

import java.util.List;

@Data
@Builder
@Jacksonized
public class SupportedVersionsResponseImpl implements SupportedVersionsResponse {
    private final List<Version> supported;
}
