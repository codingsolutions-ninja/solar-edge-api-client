package ninja.codingsolutions.solaredgeapiclient.models.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VersionResponseResponseImplTests {
    @Test
    public void canCheckEquality() {
        VersionResponseImpl impl1 = new VersionResponseImpl(VersionImpl.builder().release("test").build());
        VersionResponseImpl impl2 = new VersionResponseImpl(VersionImpl.builder().release("test").build());
        VersionResponseImpl impl3 = new VersionResponseImpl(VersionImpl.builder().release("test2").build());
        Assertions.assertEquals(impl2, impl1);
        Assertions.assertNotEquals(impl2, impl3);
        Assertions.assertNotEquals(impl2, null);
    }

    @Test
    public void canGetVersion(){
        VersionResponseImpl impl1 = new VersionResponseImpl(VersionImpl.builder().release("test").build());
        Assertions.assertEquals(impl1.getVersion().getRelease(), "test");

    }
}
