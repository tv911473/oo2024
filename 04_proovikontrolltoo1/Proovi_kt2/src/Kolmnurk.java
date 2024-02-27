import java.util.List;

public class Kolmnurk {
    List<Integer> xKoord;
    List<Integer> yKoord;

    public Kolmnurk(List<Integer> xKoord, List<Integer> yKoord) {
        this.xKoord = xKoord;
        this.yKoord = yKoord;
    }
    public int lisaKoordinaadid(int newXKoord, int newYKoord) {
        xKoord.add(newXKoord);
        yKoord.add(newYKoord);

        int summa = 0;
        for (int i: xKoord) {
            summa += i;
        }
        return summa;
    }
}
