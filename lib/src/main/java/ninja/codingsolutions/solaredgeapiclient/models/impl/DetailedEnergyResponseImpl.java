package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.DetailedEnergyResponse;
import ninja.codingsolutions.solaredgeapiclient.models.EnergyDetails;

import java.util.stream.Collectors;

/**
 * Implementation of {DetailedEnergyResponse}
 */
@lombok.EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@Jacksonized
public class DetailedEnergyResponseImpl extends ApiResponseImpl implements DetailedEnergyResponse {
    private final EnergyDetails energyDetails;

    @Override
    public Object deepCopy() {
        return super.deepCopy(builder()
                .energyDetails(EnergyDetailsImpl.builder()
                        .unit(this.getEnergyDetails().getUnit())
                        .timeUnit(this.getEnergyDetails().getTimeUnit())
                        .meters(this.getEnergyDetails().getMeters()
                                .stream()
                                .map(dme -> DetailedMeterEnergyImpl.builder()
                                        .type(dme.getType())
                                        .values(dme.getValues()
                                                .stream()
                                                .map(tsv -> TimestampedValueImpl.builder()
                                                        .date(tsv.getDate())
                                                        .value(tsv.getValue())
                                                        .build())
                                                .collect(Collectors.toList()))
                                        .build())
                                .collect(Collectors.toList()))
                        .build())
                .build());
    }
}
