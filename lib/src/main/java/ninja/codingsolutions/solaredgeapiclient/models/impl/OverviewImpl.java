package ninja.codingsolutions.solaredgeapiclient.models.impl;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.deserializers.CustomDateDeserializer;
import ninja.codingsolutions.solaredgeapiclient.models.EnergyData;
import ninja.codingsolutions.solaredgeapiclient.models.LifeTimeData;
import ninja.codingsolutions.solaredgeapiclient.models.Overview;
import ninja.codingsolutions.solaredgeapiclient.models.PowerData;
import ninja.codingsolutions.solaredgeapiclient.serializers.CustomDateSerializer;

import java.util.Date;

/**
 * Site overview information
 */
@Data
@Builder
@Jacksonized
public class OverviewImpl implements Overview {
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date lastUpdateTime;
    private LifeTimeData lifeTimeData;
    private EnergyData lastYearData;
    private EnergyData lastMonthData;
    private EnergyData lastDayData;
    private PowerData currentPower;
    private String measuredBy;
}
