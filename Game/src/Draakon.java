import java.util.Random;

public class Draakon {
    int xKoord;
    int yKoord;
    char symbol;

    public Draakon(Random random, int kaardiKorgus, int kaardiLaius) {
        // initsialiseerin (annan esimest korda algväärtuse)
        xKoord = getKoordinaat(random, kaardiLaius);
        yKoord = getKoordinaat(random, kaardiKorgus);
        symbol = 'D';
    }
    private int getKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
}
