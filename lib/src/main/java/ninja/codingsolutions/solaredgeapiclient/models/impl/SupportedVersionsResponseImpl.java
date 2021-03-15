package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.SupportedVersionsResponse;
import ninja.codingsolutions.solaredgeapiclient.models.Version;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {SupportedVersionsResponse}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@Jacksonized
public class SupportedVersionsResponseImpl extends ApiResponseImpl implements SupportedVersionsResponse {
    private final List<Version> supported;

    @Override
    public Object deepCopy() {
        return super.deepCopy(builder()
                .supported(List.copyOf(this.getSupported().stream().map(version ->
                        VersionImpl.builder()
                                .release(version.getRelease()).build()).collect(Collectors.toList()))).build());
    }
}
