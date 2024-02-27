//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Andmed andmed1 = new Andmed("MB", "S-class", "AMG", 330, 2022);
        Auto auto1 = new Auto(andmed1, 99_000, "Veho Järve");
        auto1.andmed.pakettUpdate("Premium");
        auto1.kampaania(20_000);

        Andmed andmed2 = new Andmed("VW", "Golf", "Standard", 90, 2023);
        Auto auto2 = new Auto(andmed2, 30_000, "Moller Ulemiste");
        auto2.andmed.teineMudel("Passat");
        auto2.teineEsindus("Moller Mustamae");
    }
}