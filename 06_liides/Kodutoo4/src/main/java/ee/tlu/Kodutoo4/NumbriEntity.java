package ee.tlu.Kodutoo4;

import lombok.Getter;

@Getter
public class NumbriEntity {
    int esimene;
    int teine;
    int kolmas;

    public NumbriEntity(int esimene, int teine, int kolmas) {
        this.esimene = esimene;
        this.teine = teine;
        this.kolmas = kolmas;
    }
}
