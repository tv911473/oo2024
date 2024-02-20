import java.util.Random;
public class Ese {
    String nimetus;
    double tugevus;
    int kasutuskoord;
    boolean aktiivne;
    int xKoord;
    int yKoord;
    char symbol;

    public Ese(String nimetus, double tugevus, int kasutuskoord, Random random, Maailm maailm) {
        this.nimetus = nimetus;
        this.tugevus = tugevus;
        this.kasutuskoord = kasutuskoord;
        this.aktiivne = true;
        xKoord = getKoordinaat(random, maailm.kaardiLaius);
        yKoord = getKoordinaat(random, maailm.kaardiKorgus);
        this.symbol = 'I';
    }
    public void hit() {
        System.out.println("Lõid vastast");
    }
    private int getKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
}
