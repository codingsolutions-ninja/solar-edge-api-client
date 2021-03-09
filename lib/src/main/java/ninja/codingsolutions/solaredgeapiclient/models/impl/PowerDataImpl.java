package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.PowerData;

/**
 * Power data in kWh
 */
@Data
@Builder
@Jacksonized
public class PowerDataImpl implements PowerData {
    private double power;
}
