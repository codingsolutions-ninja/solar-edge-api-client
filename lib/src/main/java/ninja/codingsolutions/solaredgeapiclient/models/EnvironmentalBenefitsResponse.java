package ninja.codingsolutions.solaredgeapiclient.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.EnvironmentalBenefitsResponseImpl;

/**
 * The API response for the estimated environmental benefits request
 */
@JsonDeserialize(as = EnvironmentalBenefitsResponseImpl.class)
public interface EnvironmentalBenefitsResponse extends ApiResponse {
    /**
     * Get an estimate of site revenue
     * @return {double} site revenue
     */
    @JsonProperty("envBenefits")
    EnvironmentalBenefits getEnvBenefits();
}
