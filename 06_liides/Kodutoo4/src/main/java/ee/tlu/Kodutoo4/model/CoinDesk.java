package ee.tlu.Kodutoo4.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CoinDesk {
    private String disclaimer;
    private String chartName;
    private Bpi bpi;
}
