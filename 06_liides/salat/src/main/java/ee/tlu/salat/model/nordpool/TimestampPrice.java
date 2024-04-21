package ee.tlu.salat.model.nordpool;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TimestampPrice {
    private int timestamp;
    private double price;
}
