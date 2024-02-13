public class Maailm {
    int kaardiKorgus;
    int kaardiLaius;

    // constructor Maailm
    public Maailm(int korgus, int laius) {
        kaardiKorgus = korgus;
        kaardiLaius = laius;
    }
    // void --> no return
    public void prindiKaart(Mangija mangija, Draakon draakon, Ork ork) {
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
                    if (x == mangija.xKoord && y == mangija.yKoord) {
                        // System.out.print(mangijaSymbol);
                        symbol = mangija.symbol;
                    } else if (x == draakon.xKoord && y == draakon.yKoord) {
                        // System.out.print(draakonSymbol);
                        symbol = draakon.symbol;
                    } else if (x == ork.xKoord && y == ork.yKoord) {
                        // System.out.print(orkSymbol);
                        symbol = ork.symbol;
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
}
