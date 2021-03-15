package ninja.codingsolutions.solaredgeapiclient.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Will try to deserialize from a zoned format first, if that doesn't work it falls back to
 * the time zone less format used by the solar edge api, the reason for doing this is to support
 * parsing the format provided by solar edge, while providing preferred zoned serialization/deserialization
 * when using the models for other data exchange processes.
 */
public class CustomDateDeserializer extends StdDeserializer<Date> {
    /**
     * Solar edge time zone less format
     */
    private final SimpleDateFormat solarEdgeDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    /**
     * Simple date formatter that handles the format provided from the Solar Edge Api that only contains date information
     */
    private final SimpleDateFormat solarEdgeDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * Simple date foramtter that generates ISO-8601 time format strings
     */
    private final SimpleDateFormat iso8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    /**
     * No Arg constructor for customer date deserializer, calls <code>super(Date.class)</code>
     */
    public CustomDateDeserializer() {
        super(Date.class);
    }

    /**
     * Method that can be called to ask implementation to deserialize
     * JSON content into the value type this serializer handles.
     * Returned instance is to be constructed by method itself.
     * <p>
     * Pre-condition for this method is that the parser points to the
     * first event that is part of value to deserializer (and which
     * is never JSON 'null' literal, more on this below): for simple
     * types it may be the only value; and for structured types the
     * Object start marker or a FIELD_NAME.
     * </p>
     * The two possible input conditions for structured types result
     * from polymorphism via fields. In the ordinary case, Jackson
     * calls this method when it has encountered an OBJECT_START,
     * and the method implementation must advance to the next token to
     * see the first field name. If the application configures
     * polymorphism via a field, then the object looks like the following.
     * <pre>
     *      {
     *          "@class": "class name",
     *          ...
     *      }
     *  </pre>
     * Jackson consumes the two tokens (the <code>@class</code> field name
     * and its value) in order to learn the class and select the deserializer.
     * Thus, the stream is pointing to the FIELD_NAME for the first field
     * after the @class. Thus, if you want your method to work correctly
     * both with and without polymorphism, you must begin your method with:
     * <pre>
     *       if (jp.getCurrentToken() == JsonToken.START_OBJECT) {
     *         jp.nextToken();
     *       }
     *  </pre>
     * This results in the stream pointing to the field name, so that
     * the two conditions align.
     * <p>
     * Post-condition is that the parser will point to the last
     * event that is part of deserialized value (or in case deserialization
     * fails, event that was not recognized or usable, which may be
     * the same event as the one it pointed to upon call).
     * </p>
     * Note that this method is never called for JSON null literal,
     * and thus deserializers need (and should) not check for it.
     *
     * @param jp   Parsed used for reading JSON content
     * @param ctxt Context that can be used to access information about
     *             this deserialization activity.
     * @return Deserialized value
     */
    @Override
    public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        String jsonStr = jp.getText();

        Date returnDate = null;
        String timeZone = "UTC";
        try {
            iso8601.setTimeZone(TimeZone.getTimeZone(timeZone));
            returnDate = iso8601.parse(jsonStr);
        } catch (ParseException ignored) {
            //ignored//
        }
        if (returnDate == null ) {
            try {
                returnDate = solarEdgeDateTimeFormat.parse(jsonStr);
            } catch (ParseException ignored) {
                //ignored
            }
        }
        if (returnDate == null ) {
            try {
                solarEdgeDateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
                returnDate = solarEdgeDateFormat.parse(jsonStr);
            } catch (ParseException e) {
                throw new IOException(e.getMessage());
            }
        }
        return returnDate;
    }
}
