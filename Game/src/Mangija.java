import java.util.Random;

public class Mangija {
    int xKoord; // aktiveeri lõik, option + command + m --> teeb funktsiooni
    int yKoord; // refactor -> rename -> enter (muudab muutuja nime kõikjal)
    char symbol;

    Suund suund;

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
                if (yKoord < maailm.kaardiKorgus - 1) yKoord++; // = + 1
            }
            case VASAKULE -> {
                if (xKoord > 1) xKoord--;
            }
            case PAREMALE -> {
                if (xKoord < maailm.kaardiLaius - 1) xKoord++;
            }
        } // switch() close
    } // liigub() func close
    private int getKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
} // mangija close

// static ei vaja “new” function, classides != static, mainis = static