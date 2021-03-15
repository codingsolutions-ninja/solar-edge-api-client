package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.Version;
import ninja.codingsolutions.solaredgeapiclient.models.VersionResponse;

/**
 * Implementation of {VersionResponse}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Jacksonized
@SuperBuilder
public class VersionResponseImpl extends ApiResponseImpl implements VersionResponse {
    private Version version;

    @Override
    public Object deepCopy() {
        return super.deepCopy(builder()
                .version(VersionImpl.builder().release(this.getVersion().getRelease()).build())
                .build());
    }
}
