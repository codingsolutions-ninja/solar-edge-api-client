package ninja.codingsolutions.solaredgeapiclient.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

/**
 * Power data in kWh
 */
@Data
@Builder
@Jacksonized
public class PowerData {
    private double power;
}
