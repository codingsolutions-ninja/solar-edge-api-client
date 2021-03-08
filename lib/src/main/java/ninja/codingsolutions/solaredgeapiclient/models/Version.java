package ninja.codingsolutions.solaredgeapiclient.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.VersionImpl;

@JsonDeserialize(as = VersionImpl.class)
public interface Version {
    String getRelease();
}
