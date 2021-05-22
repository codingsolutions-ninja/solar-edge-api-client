package ninja.codingsolutions.solaredgeapiclient.models.impl;

import ninja.codingsolutions.solaredgeapiclient.models.EnvironmentalBenefits;
import ninja.codingsolutions.solaredgeapiclient.models.EnvironmentalBenefitsResponse;

public class EnvironmentalBenefitsResponseImpl extends ApiResponseImpl implements EnvironmentalBenefitsResponse {
    protected EnvironmentalBenefitsResponseImpl(ApiResponseImplBuilder<?, ?> b) {
        super(b);
    }

    @Override
    public EnvironmentalBenefits getEnvironmentalBenefits() {
        return null;
    }

    /**
     * Create and return a deep copy of the current object
     *
     * @return {Object} deep copy of current object
     */
    @Override
    public Object deepCopy() {
        return null;
    }
}
