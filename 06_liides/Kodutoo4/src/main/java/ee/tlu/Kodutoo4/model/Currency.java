package ee.tlu.Kodutoo4.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Currency {
    private String code;
    private String symbol;
    private String rate;
    private String description;
    private double rate_float;
}
