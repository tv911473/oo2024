import java.util.Random;

public class Ork extends Tegelane implements JuhuslikKoordinaat{
    public Ork(Random random, int kaardiKorgus, int kaardiLaius) {
        // initsialiseerin (annan esimest korda algväärtuse)
        xKoord = getKoordinaat(random, kaardiLaius);
        yKoord = getKoordinaat(random, kaardiKorgus);
        symbol = 'O';
    }
    public int getKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
}
