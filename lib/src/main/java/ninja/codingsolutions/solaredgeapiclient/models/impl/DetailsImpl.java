package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.*;

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
    private Date lastUpdateTime;
    private String currency;
    private Date installationDate;
    private String ptoDate;
    private String notes;
    private String type;
    private Location location;
    private PrimaryModule primaryModule;
    private Uris uris;
    private PublicSettings publicSettings;
}
