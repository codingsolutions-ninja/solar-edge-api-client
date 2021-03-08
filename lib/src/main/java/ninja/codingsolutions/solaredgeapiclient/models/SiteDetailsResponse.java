package ninja.codingsolutions.solaredgeapiclient.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ninja.codingsolutions.solaredgeapiclient.models.impl.SiteDetailsResponseImpl;

@JsonDeserialize(as = SiteDetailsResponseImpl.class)
public interface SiteDetailsResponse {
    Details getDetails();
}
