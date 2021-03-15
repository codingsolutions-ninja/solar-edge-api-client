package ninja.codingsolutions.solaredgeapiclient.models.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import ninja.codingsolutions.solaredgeapiclient.interfaces.DeepCopyable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Random;

public abstract class BaseModelTest {
    protected static Random random = new Random();
    protected abstract DeepCopyable buildRandomObject();
    protected abstract Class<?> getDeserializiableClass();

    @Test
    public void canSerDer() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());

        Object obj = this.buildRandomObject();
        String jsonStr = mapper.writeValueAsString(obj);
        Object deserializedObject = mapper.readValue(jsonStr, this.getDeserializiableClass());
        Assertions.assertEquals(obj, deserializedObject);
    }

    @Test
    public void canCheckEquality() throws CloneNotSupportedException {
        DeepCopyable obj = this.buildRandomObject();
        Object clone = obj.deepCopy();
        Assertions.assertEquals(obj, clone);
    }

    @Test
    public void consistentHashCode() throws CloneNotSupportedException {
        DeepCopyable obj = this.buildRandomObject();
        Object clone = obj.deepCopy();
        Assertions.assertEquals(obj.hashCode(), clone.hashCode());
    }

    public String getRandomString() {
        return Double.toString(random.nextDouble());
    }
}
