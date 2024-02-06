//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // KODUS: 3 funktsiooni, milles kasutatud vähemalt
        // nelja erinevat tyypi:
        // void, String, int, char, long, double, float, boolean
        // tagastab int     parameetriks boolean
        // tagastab void    parameetriks boolean, int
        // tagastab String  parameetriks String

        // teha igast funktsioonist 2 erineva sisendiga väljakutset

        double kogumaksumus1 = arvutaTaksoMaksumus(3);
        System.out.println(kogumaksumus1);
        double kogumaksumus2 = arvutaTaksoMaksumus(2);
        System.out.println(kogumaksumus2);
        String hinnang1 = temperatuuriHinnang(-1.2);
        System.out.println(hinnang1);
        String hinnang2 = temperatuuriHinnang(2.2);
        System.out.println(hinnang2);
        prindiForTsykkel("Pikk sona");
        prindiForTsykkel("Lyhike sona");

    }
    // Siia kirjutad koodi
    private static double arvutaTaksoMaksumus(int tunnid) { // double on komakohaga arv
        return 3 + 0.9*tunnid;
    }

    private static String temperatuuriHinnang(double temp) {
        if (temp < 0) {
            return "vesi on jääs";
        } else {
            return "on vesi";
        }
    }
    private static void prindiForTsykkel(String tahtedeArv) {
        for (int i = 0; i < tahtedeArv.length(); i++) {
            System.out.println(i);

        }
    }
}