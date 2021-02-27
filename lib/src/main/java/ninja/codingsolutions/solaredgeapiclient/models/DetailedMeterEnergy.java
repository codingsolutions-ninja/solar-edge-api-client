package ninja.codingsolutions.solaredgeapiclient.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Builder
@Jacksonized
@Data
public class DetailedMeterEnergy {
    private final MeterType type;
    private final List<TimestampedValue> values;
}
