import java.util.Random;

// igal klassil (Mangija) saab olla 1 ülemklass (Tegelane)
// extends võtab "Tegelane" classist x, y, symbol
// interface (JuhuslikKoordinaat) kohustab kasutama selle sees olevaid asju
public class Mangija extends Tegelane implements JuhuslikKoordinaat {
    Suund suund;
    Ese ese; // klassikomplekt
    Soiduk soiduk;

    // "create constructor" abil loodud public Mangija
    public Mangija(Random random, int kaardiKorgus, int kaardiLaius) {
        // initsialiseerin (annan esimest korda algväärtuse)
        xKoord = getKoordinaat(random, kaardiLaius);
        yKoord = getKoordinaat(random, kaardiKorgus);
        symbol = '*';
        suund = Suund.YLES;
    }

    public void liigub(String sisend, Maailm maailm) {
        switch (sisend) {
            case "w" -> suund = Suund.YLES; // = -1
            case "s" -> suund = Suund.ALLA; // = + 1
            case "a" -> suund = Suund.VASAKULE;
            case "d" -> suund = Suund.PAREMALE;
        } // switch() close
        switch (suund) {
            case YLES -> {
                if (yKoord > 1) yKoord--; // = -1
            }
            case ALLA -> {
                if (yKoord < maailm.kaardiKorgus - 2) yKoord++; // = + 1
            }
            case VASAKULE -> {
                if (xKoord > 1) xKoord--;
            }
            case PAREMALE -> {
                if (xKoord < maailm.kaardiLaius - 2) xKoord++;
            }
        } // switch() close
    } // liigub() func close
    public int getKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
} // mangija close

// static ei vaja “new” functioni, classides != static, mainis = static