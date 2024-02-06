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

        int oige = oigeVoiVaar(true);
        System.out.println(oige);
        int vaar = oigeVoiVaar(false);
        System.out.println(vaar);

        String algus = stringFunc("algus");
        System.out.println(algus);
        String lopp = stringFunc("lopp");
        System.out.println(lopp);

        forLoop(10, true);
        System.out.println();
        forLoop(20, false);

    }
    // Siia kirjutad koodi

    private static int oigeVoiVaar(boolean sisend) { // double on komakohaga arv
        if (sisend) {
            return 1;
        } else {
            return 0;
        }
    }

    private static String stringFunc(String sona) {
        if (sona.equals("algus")) {
            return "see on algus";
        } else if (sona.equals("lopp")){
            return "see on lopp";
        } else {
            return "";
        }

    }
    private static void forLoop(int pikkus, boolean sisend) {
        if (sisend)
            for (int i = 0; i < pikkus; i++) {
            System.out.println(i);
        }
    }
}