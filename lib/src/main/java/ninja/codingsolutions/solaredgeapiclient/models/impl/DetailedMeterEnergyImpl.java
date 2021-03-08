package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.DetailedMeterEnergy;
import ninja.codingsolutions.solaredgeapiclient.models.MeterType;
import ninja.codingsolutions.solaredgeapiclient.models.TimestampedValue;

import java.util.List;

@Builder
@Jacksonized
@Data
public class DetailedMeterEnergyImpl implements DetailedMeterEnergy {
    private final MeterType type;
    private final List<TimestampedValue> values;
}
