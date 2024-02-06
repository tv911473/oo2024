import java.util.Random;
import java.util.Scanner;
// control + G --> valib jargmise aktiivseks, sama mis command + D VS Codeis

public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        // kaardi koordinaadid
        int kaardiKorgus = 5;
        int kaardiLaius = 10;

        // tegelane & koordinaadid
        int mangijaXKoord = getKoordinaat(random, kaardiLaius); // aktiveeri lõik, option + command + m --> teeb funktsiooni
        int mangijaYKoord = getKoordinaat(random, kaardiKorgus);
        char mangijaSymbol = '*';

        int draakonXKoord = getKoordinaat(random, kaardiLaius);
        int draakonYKoord = getKoordinaat(random, kaardiKorgus);
        char draakonSymbol = 'D';

        int orkXKoord = getKoordinaat(random, kaardiLaius);
        int orkYKoord = getKoordinaat(random, kaardiKorgus);
        char orkSymbol = 'O';

        // import.java.Scanner;
        Scanner scanner = new Scanner(System.in); // tyybid on eristatavad suure tahega nt Scanner

        prindiKaart(kaardiKorgus, kaardiLaius, mangijaXKoord, mangijaYKoord, mangijaSymbol, draakonXKoord, draakonYKoord, draakonSymbol, orkXKoord, orkYKoord, orkSymbol);

        String sisend = scanner.nextLine(); // kasutaja sisend, joon all tähendab muutuv muutuja

        switch (sisend) {
            case "w" -> mangijaYKoord--; // = -1
            case "s" -> mangijaYKoord++; // = + 1
            case "a" -> mangijaXKoord--;
            case "d" -> mangijaXKoord++;
        }



        while (!sisend.equals("end")) { // muutuja.equals() --> ==    !muutuja.equals() --> !=
            prindiKaart(kaardiKorgus, kaardiLaius, mangijaXKoord, mangijaYKoord, mangijaSymbol, draakonXKoord, draakonYKoord, draakonSymbol, orkXKoord, orkYKoord, orkSymbol);

            sisend = scanner.nextLine(); // kasutaja sisend w, s, a, d liikumise suund
            switch (sisend) {
                case "w" -> mangijaYKoord--; // = -1
                case "s" -> mangijaYKoord++; // = + 1
                case "a" -> mangijaXKoord--;
                case "d" -> mangijaXKoord++;
            }
        }



    } // main (args[])

    // void --> no return
    private static void prindiKaart(int kaardiKorgus, int kaardiLaius, int mangijaXKoord, int mangijaYKoord, char mangijaSymbol, int draakonXKoord, int draakonYKoord, char draakonSymbol, int orkXKoord, int orkYKoord, char orkSymbol) {
        for (int y = 0; y < kaardiKorgus; y++) {
            for (int x = 0; x < kaardiLaius; x++) {
                char symbol;
                if (y == 0 || y == kaardiKorgus -1) {
                    // System.out.print('-');
                    symbol = '-';
                } else if (x == 0 || x == kaardiLaius -1) {
                    // System.out.print('|');
                    symbol = '|';
                } else {
                    if (x == mangijaXKoord && y == mangijaYKoord) {
                        // System.out.print(mangijaSymbol);
                        symbol = mangijaSymbol;
                    } else if (x == draakonXKoord && y == draakonYKoord) {
                        // System.out.print(draakonSymbol);
                        symbol = draakonSymbol;
                    } else if (x == orkXKoord && y == orkYKoord) {
                        // System.out.print(orkSymbol);
                        symbol = orkSymbol;
                    } else {
                        // System.out.print(' ');
                        symbol = ' ';
                    }
                }
                System.out.print(symbol);
            }
            System.out.println();
        } // for loop
    }

    // loodud funktsioon option + command + m
    private static int getKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
} // Main ()