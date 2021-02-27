package ninja.codingsolutions.solaredgeapiclient.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;

@Builder
@Jacksonized
@Data
public class TimestampedValue {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private final Date date;
    private final double value;

}
