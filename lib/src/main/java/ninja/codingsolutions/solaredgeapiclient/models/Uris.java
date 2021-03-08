package ninja.codingsolutions.solaredgeapiclient.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.UrisImpl;

@JsonDeserialize(as = UrisImpl.class)
public interface Uris {
    String getSiteImage();

    String getDataPeriod();

    String getDetails();

    String getOverview();
}
