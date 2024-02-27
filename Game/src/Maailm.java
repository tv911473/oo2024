import java.util.List;

public class Maailm {
    int kaardiKorgus;
    int kaardiLaius;

    // constructor Maailm
    public Maailm(int korgus, int laius) {
        kaardiKorgus = korgus;
        kaardiLaius = laius;
    }
    // void --> no return
    public void prindiKaart(List<Tegelane> tegelased, List<Ese> esemed) {
        for (int y = 0; y < kaardiKorgus; y++) {
            for (int x = 0; x < kaardiLaius; x++) {
                char symbol;
                if (y == 0 || y == kaardiKorgus -1) {
                    symbol = '-';
                } else if (x == 0 || x == kaardiLaius -1) {
                    symbol = '|';
                } else {
                    symbol = ' ';
                    for (Ese e : esemed) {
                        if (e.xKoord == x && e.yKoord == y) {
                            symbol = e.symbol;
                        }
                    }
                    for (Tegelane t : tegelased) {
                        if (t.xKoord == x && t.yKoord == y) {
                            symbol = t.symbol;
                        }
                    }
                }
                System.out.print(symbol);
            }
            System.out.println();
        } // for loop
    }
}
