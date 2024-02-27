import java.util.ArrayList;
import java.util.List;

public class Keskmine {
    List<Double> arvud = new ArrayList<>();
    List<Double> keskArvud = new ArrayList<>();

    // Keskmine keskmine = new Keskmine(2,4,6)
    public Keskmine(List<Double> arvudAlguses) {
        arvud = arvudAlguses;
        arvutaLibisevKeskmine();
    }

    public void lisaArv(Double arv) {
        Double viimane = arvud.get(arvud.size() - 1);
        Double eelViimane = arvud.get(arvud.size() - 2);
        Double keskmine = (viimane + eelViimane + arv) / 3;
        keskArvud.add(keskmine);

        arvud.add(arv);

    }
    public List<Double> saaKeskArvud() {
        return keskArvud;
    }
    private void arvutaLibisevKeskmine() {

        for (int i = 0; i < arvud.size() - 2; i++) { // arvud.size() - 2 -> kahe elemendi vorra lyhem
            double summa = arvud.get(i) + arvud.get(i + 1) + arvud.get(i + 2);
            double libisevKeskmine = summa / 3;
            keskArvud.add(libisevKeskmine);
        }
    }
}
