package ee.tlu.salat;

import lombok.Getter;

@Getter
public class ToiduaineEntity {
    String nimetus;
    int valk;
    int rasv;
    int sysivesik;

    public ToiduaineEntity(String nimetus, int valk, int rasv, int sysivesik) {
        this.nimetus = nimetus;
        this.valk = valk;
        this.rasv = rasv;
        this.sysivesik = sysivesik;
    }

}
