package ninja.codingsolutions.solaredgeapiclient.models.impl;

import ninja.codingsolutions.solaredgeapiclient.interfaces.DeepCopyable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class VersionResponseImplTests extends BaseModelTest {

    @Test
    void canGetVersion(){
        VersionResponseImpl impl1 = VersionResponseImpl.builder()
                .version(VersionImpl.builder().release("TEST_RELEASE").build())
                .siteIds(List.of(1))
                .build();

        Assertions.assertEquals( "TEST_RELEASE", impl1.getVersion().getRelease());
    }

    @Override
    DeepCopyable buildRandomObject() {
        return VersionResponseImpl.builder()
                .version(VersionImpl.builder()
                .release(Double.toString(random.nextDouble())).build())
                .siteIds(List.of(random.nextInt())).build();
    }

    @Override
    Class<?> getDeserializiableClass() {
        return VersionResponseImpl.class;
    }

}
