package ninja.codingsolutions.solaredgeapiclient.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.DetailedEnergyResponseImpl;

@JsonDeserialize(as = DetailedEnergyResponseImpl.class)
public interface DetailedEnergyResponse {
    EnergyDetails getEnergyDetails();
}
