package ee.tlu.salat.model.nordpool;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@NoArgsConstructor
public class Data {
    private ArrayList<TimestampPrice> ee;
    private ArrayList<TimestampPrice> fi;
    private ArrayList<TimestampPrice> lv;
    private ArrayList<TimestampPrice> lt;
}
