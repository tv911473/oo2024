public class Kasutaja {
    String nimi;
    boolean aktiivne;
    int vanus;
    char lyhend;
    double raha;

    // parem klõps -> Generate -> Constructor
    // shift hoian peal ja vajutan viimasele
    public Kasutaja(String nimi, boolean aktiivne, int vanus, char lyhend, double raha) {
        this.nimi = nimi;
        this.aktiivne = aktiivne;
        this.vanus = vanus;
        this.lyhend = lyhend;
        this.raha = raha;
    }

    public void muudaAktiivne() {
        aktiivne = !aktiivne;
    }

    public double lisaRaha(double summa) {
        raha = raha + summa;
        return raha;
    }
}
