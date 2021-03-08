package ninja.codingsolutions.solaredgeapiclient.models;

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
