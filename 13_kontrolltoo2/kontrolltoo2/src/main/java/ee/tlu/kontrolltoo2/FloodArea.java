package ee.tlu.kontrolltoo2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FloodArea {
    @JsonProperty("@id")
    public String id;
    public String county;
    public String notation;
    public String polygon;
    public String riverOrSea;
}
