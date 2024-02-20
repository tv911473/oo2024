import java.util.ArrayList;
import java.util.List;
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
        List<Tegelane> tegelased = new ArrayList<>();
        tegelased.add(mangija);
        tegelased.add(draakon);
        tegelased.add(ork);


        Ese m66k = new Ese("Mõõk", 10, 1, random, maailm);
        Ese haamer = new Ese("Haamer", 5, 3, random, maailm);
        Ese saabas = new Ese("Saabas", 1, 5, random, maailm);
        List<Ese> esemed = new ArrayList<Ese>();
//        List<Integer> t2isarvulised;
//        List<String> s6nalised;
        esemed.add(m66k);
        esemed.add(haamer);
        esemed.add(saabas);

        // import.java.Scanner;
        Scanner scanner = new Scanner(System.in); // tyybid on eristatavad suure tahega nt Scanner

        maailm.prindiKaart(tegelased, esemed);

        String sisend = scanner.nextLine(); // kasutaja sisend, joon all tähendab muutuv muutuja

        mangija.liigub(sisend, maailm);

        while (!sisend.equals("end")) { // muutuja.equals() --> ==    !muutuja.equals() --> !=
            maailm.prindiKaart(tegelased, esemed);
            sisend = scanner.nextLine(); // kasutaja sisend w, s, a, d liikumise suund
            mangija.liigub(sisend, maailm);
            for (Ese e: esemed) {
                if (mangija.xKoord == e.xKoord && mangija.yKoord == e.yKoord) {
                    mangija.ese = e;
                    System.out.println("korjasid ülesse eseme: " + e.nimetus);
                    break;
                }
            }
        }

    } // main (args[])

    // loodud funktsioon option + command + m
//    private static int getKoordinaat(Random random, int kaart) {
//        return random.nextInt(1, kaart - 1);
//    }
} // Main ()