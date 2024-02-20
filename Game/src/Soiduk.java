import java.util.Random;

public class Soiduk {
    int kiirus;
    String nimetus;
    int xKoord;
    int yKoord;
    char symbol;

    public Soiduk(int kiirus, String nimetus, Random random, Maailm maailm) {
        this.kiirus = kiirus;
        this.nimetus = nimetus;
//        xKoord = getKoordinaat(random, kaardiLaius);
//        yKoord = getKoordinaat(random, kaardiKorgus);
        this.symbol = 'S';
    }
}
