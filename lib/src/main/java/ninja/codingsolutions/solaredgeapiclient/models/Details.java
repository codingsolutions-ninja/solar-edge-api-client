package ninja.codingsolutions.solaredgeapiclient.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.DetailsImpl;

@JsonDeserialize(as = DetailsImpl.class)
public interface Details {
    int getId();

    String getName();

    int getAccountId();

    String getStatus();

    double getPeakPower();

    java.util.Date getLastUpdateTime();

    String getCurrency();

    java.util.Date getInstallationDate();

    String getPtoDate();

    String getNotes();

    String getType();

    Location getLocation();

    PrimaryModule getPrimaryModule();

    Uris getUris();

    PublicSettings getPublicSettings();
}
