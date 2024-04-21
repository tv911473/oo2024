package ee.tlu.Kodutoo4.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Bpi {
    @JsonProperty("USD")
    private Currency uSD;
    @JsonProperty("GBP")
    private Currency gBP;
    @JsonProperty("EUR")
    private Currency eUR;
}
