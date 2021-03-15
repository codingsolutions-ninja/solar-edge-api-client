package ninja.codingsolutions.solaredgeapiclient.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Customer serializer for {Date} objects that serializes out in ISO-8601
 */
public class CustomDateSerializer extends StdSerializer<Date> {
    private final SimpleDateFormat iso8601;

    /**
     * No Arg constructor for CustomDateSerializer, calls <code>super(Date.class)</code>
     */
    public CustomDateSerializer() {
        super(Date.class);
        iso8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    }

    /**
     * Serialize Date to ISO-8601 string on json property
     * @param value Date value
     * @param jgen Json Generator
     * @param provider serializer provider
     * @throws IOException thrown if any exception occurs during generation and write of json value
     */
    @Override
    public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        iso8601.setTimeZone(TimeZone.getTimeZone("UTC"));
        jgen.writeString(iso8601.format(value));
    }
}
