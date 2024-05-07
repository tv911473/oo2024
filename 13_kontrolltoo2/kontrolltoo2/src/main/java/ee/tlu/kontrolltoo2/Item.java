package ee.tlu.kontrolltoo2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class Item {
    @JsonProperty("@id")
    public String id;
    public String description;
    public String eaAreaName;
    public String eaRegionName;
    public FloodArea floodArea;
    public String floodAreaID;
    public boolean isTidal;
    public String message;
    public String severity;
    public int severityLevel;
    public Date timeMessageChanged;
    public Date timeRaised;
    public Date timeSeverityChanged;
}
