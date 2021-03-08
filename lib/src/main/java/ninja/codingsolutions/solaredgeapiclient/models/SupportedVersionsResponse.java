package ninja.codingsolutions.solaredgeapiclient.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.SupportedVersionsResponseImpl;

@JsonDeserialize(as = SupportedVersionsResponseImpl.class)
public interface SupportedVersionsResponse {
    java.util.List<Version> getSupported();
}
