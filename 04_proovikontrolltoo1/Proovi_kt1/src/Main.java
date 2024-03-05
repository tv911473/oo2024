import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        double keskmine = aritmeetika(2, 4, 6);
        System.out.println(keskmine);

        List<Double> arvud = new ArrayList<>();
        arvud.add(2.0);
        arvud.add(4.0);
        arvud.add(6.0);
        List<Double> libisevKeskmine = arvutaLibisevKeskmine(arvud);
        System.out.println(libisevKeskmine);

        Keskmine keskmine1 = new Keskmine(arvud);
        List<Double> libisevkeskmine = keskmine1.saaKeskArvud();
        System.out.println(libisevkeskmine);
        keskmine1.lisaArv(10.0);
        List<Double> libisevkeskmine2 = keskmine1.saaKeskArvud();
        System.out.println(libisevkeskmine2);
    }

    // * Koosta funktsioon kolme arvu aritmeetilise keskmise leidmiseks. Katseta.
    private static double aritmeetika(double arv1, double arv2, double arv3) {
        return (arv1 + arv2 + arv3) / 3;
    }

    ;

    //  * Koosta funktsioon massiivi libiseva keskmise leidmiseks. Väljundiks on massiiv, mis on sisendist kahe elemendi võrra lühem ning mille iga elemendi väärtuseks on sisendmassiivi vastava elemendi ning selle järgmise ja ülejärgmise elemendi keskmine.
    private static List<Double> arvutaLibisevKeskmine(List<Double> arvud) {
        List<Double> keskArvud = new ArrayList<>();
        for (int i = 0; i < arvud.size() - 2; i++) { // arvud.size() - 2 -> kahe elemendi vorra lyhem
            double summa = arvud.get(i) + arvud.get(i + 1) + arvud.get(i + 2);
            double libisevKeskmine = summa / 3;
            keskArvud.add(libisevKeskmine);
        }
        return keskArvud;
    }

    ;
    // * Koosta klass, mille eksemplarile saab vastava käsuga lisada arve. Teise käsuga saab küsida nende arvude libiseva keskmise massiivi vastavalt eelmise punkti juhendile. Koosta  kood nõnda, et uue arvu lisamisel eksemplarile tehtaks uusi arvutusi võimalikult vähe (st. ei arvutataks kogu tulemust massiivi algusest uuesti)

}