package ninja.codingsolutions.solaredgeapiclient.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;

@Data
@Builder
@Jacksonized
public class Overview {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private Date lastUpdateTime;
    private LifeTimeData lifeTimeData;
    private EnergyData lastYearData;
    private EnergyData lastMonthData;
    private EnergyData lastDayData;
    private PowerData currentPower;
    private String measuredBy;
}
