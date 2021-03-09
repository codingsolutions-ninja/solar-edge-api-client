package ninja.codingsolutions.solaredgeapiclient.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.VersionResponseImpl;

@JsonDeserialize(as = VersionResponseImpl.class)
public interface VersionResponse {
    Version getVersion();
}
