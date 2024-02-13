//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Main class + Enda tehtud class
        // Classis constructor
        // vähemalt 2 omadust
        // vähemalt 2 funktsiooni

        // Mainis vähemalt kaks instantsi temast
        // Mainis vähemalt 2 funktsiooni väljakutset
        // vähemalt 2 System.out.println()

        Kasutaja kasutaja1 = new Kasutaja("M", true, 30, 'x', 0.0);
        Kasutaja kasutaja2 = new Kasutaja("S", false, 35, 'y', 100.0);

        kasutaja1.muudaAktiivne();
        System.out.println(kasutaja1.aktiivne);
        double kasutaja2Raha = kasutaja2.lisaRaha(500.0);
        System.out.println(kasutaja2Raha);

        Tellimus tellimus1 = new Tellimus("M", 199.0, "Coca");
        Tellimus tellimus2 = new Tellimus("S", 299.5, "Fanta");

        double dollarites = tellimus1.tellimuseSummaDollarites();
        System.out.println(dollarites);

        tellimus2.tellijaNimeVahetus("Y");
        System.out.println(tellimus2.tellija);
    }
}