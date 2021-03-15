package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.Version;

/**
 * Implementation of {Version}
 */
@Data
@Jacksonized
@Builder
public class VersionImpl implements Version {
    private final String release;

    @Override
    public Object deepCopy() {
        return new VersionImpl(this.getRelease());
    }
}
