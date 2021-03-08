package ninja.codingsolutions.solaredgeapiclient.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.OverviewResponseImpl;

@JsonDeserialize(as = OverviewResponseImpl.class)
public interface OverviewResponse {
    Overview getOverview();
}
