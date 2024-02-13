import java.util.Random; // Random class
import java.util.Scanner; // Scanner class
// classi sees on ainult muutujat ja funktsioonid
// control + G --> valib jargmise aktiivseks, sama mis command + D VS Codeis

public class Main {
    public static void main(String[] args) {

        Random random = new Random(); // uus class algab "new"

        Maailm maailm = new Maailm(5, 10);

        // create constructor (punane joon all)
        Mangija mangija = new Mangija(random, maailm.kaardiKorgus, maailm.kaardiLaius); // class Mangija()
        Draakon draakon = new Draakon(random, maailm.kaardiKorgus, maailm.kaardiLaius);
        Ork ork = new Ork(random, maailm.kaardiKorgus, maailm.kaardiLaius);

        // import.java.Scanner;
        Scanner scanner = new Scanner(System.in); // tyybid on eristatavad suure tahega nt Scanner

        maailm.prindiKaart(mangija, draakon, ork);

        String sisend = scanner.nextLine(); // kasutaja sisend, joon all tähendab muutuv muutuja

        mangija.liigub(sisend, maailm);

        while (!sisend.equals("end")) { // muutuja.equals() --> ==    !muutuja.equals() --> !=
            maailm.prindiKaart(mangija, draakon, ork);

            sisend = scanner.nextLine(); // kasutaja sisend w, s, a, d liikumise suund
            mangija.liigub(sisend, maailm);
        }

    } // main (args[])

    // loodud funktsioon option + command + m
//    private static int getKoordinaat(Random random, int kaart) {
//        return random.nextInt(1, kaart - 1);
//    }
} // Main ()