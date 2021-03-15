package ninja.codingsolutions.solaredgeapiclient.models.impl;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.deserializers.CustomDateDeserializer;
import ninja.codingsolutions.solaredgeapiclient.models.Details;
import ninja.codingsolutions.solaredgeapiclient.models.Location;
import ninja.codingsolutions.solaredgeapiclient.models.PrimaryModule;
import ninja.codingsolutions.solaredgeapiclient.models.PublicSettings;
import ninja.codingsolutions.solaredgeapiclient.models.Uris;
import ninja.codingsolutions.solaredgeapiclient.serializers.CustomDateSerializer;

import java.util.Date;

/**
 * Detailed site information
 */
@Builder
@Data
@Jacksonized
public class DetailsImpl implements Details {
    private int id;
    private String name;
    private int accountId;
    private String status;
    private double peakPower;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date lastUpdateTime;
    private String currency;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date installationDate;
    private String ptoDate;
    private String notes;
    private String type;
    private Location location;
    private PrimaryModule primaryModule;
    private Uris uris;
    private PublicSettings publicSettings;
}
