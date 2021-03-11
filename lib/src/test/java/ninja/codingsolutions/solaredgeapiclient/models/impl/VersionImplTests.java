package ninja.codingsolutions.solaredgeapiclient.models.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VersionImplTests {

    @Test
    public void canSeedVersion() {
        String initialVersion = "TEST RELEASE";
        String versionChange = "TEST RELEASE 2";
        VersionImpl impl = new VersionImpl(initialVersion);
        Assertions.assertEquals(initialVersion, impl.getRelease());

        VersionImpl impl2 = VersionImpl.builder().release(versionChange).build();
        Assertions.assertEquals(versionChange, impl2.getRelease());

    }
}
