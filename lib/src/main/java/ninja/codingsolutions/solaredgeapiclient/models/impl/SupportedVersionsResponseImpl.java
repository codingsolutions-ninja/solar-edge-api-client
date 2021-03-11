package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.SupportedVersionsResponse;
import ninja.codingsolutions.solaredgeapiclient.models.Version;

import java.util.List;

/**
 * Implementation of {SupportedVersionsResponse}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Jacksonized
public class SupportedVersionsResponseImpl extends ApiResponseImpl implements SupportedVersionsResponse {
    private final List<Version> supported;
}
