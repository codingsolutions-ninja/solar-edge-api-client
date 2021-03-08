package ninja.codingsolutions.solaredgeapiclient.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.PublicSettingsImpl;

@JsonDeserialize(as = PublicSettingsImpl.class)
public interface PublicSettings {
    boolean isPublic();
}
