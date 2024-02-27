import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // * Koosta klass, milles on üks massiiv kolmnurga x-koordinaatide hoidmiseks ning teine massiiv y-koordinaatide hoidmiseks. Koosta klassist kaks eksemplari, määra algväärtused ning trüki andmed välja.
        List<Integer> kolmnurk1xKoord = new ArrayList<>();
        kolmnurk1xKoord.add(6);
        kolmnurk1xKoord.add(8);
        kolmnurk1xKoord.add(10);

        List<Integer> kolmnurk1yKoord = new ArrayList<>();
        kolmnurk1yKoord.add(2);
        kolmnurk1yKoord.add(5);
        kolmnurk1yKoord.add(1);

        Kolmnurk kolmnurk = new Kolmnurk(kolmnurk1xKoord, kolmnurk1yKoord);

        System.out.println(kolmnurk.xKoord);
        System.out.println(kolmnurk.yKoord);

        // * Lisa klassile käsklus punkti koordinaadipaari lisamiseks. Käsklusena väljasta tekkiva hulknurga ümbermõõt (küljepikkuste summa).
        int ymbermoot = kolmnurk.lisaKoordinaadid(5, 10);
        System.out.println(ymbermoot);




    }
}