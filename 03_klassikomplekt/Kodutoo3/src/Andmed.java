public class Andmed {
    String mark;
    String mudel;
    String pakett;
    int kw;
    int aasta;

    public Andmed(String mark, String mudel, String pakett, int kw, int aasta) {
        this.mark = mark;
        this.mudel = mudel;
        this.pakett = pakett;
        this.kw = kw;
        this.aasta = aasta;
    }
    public void pakettUpdate(String uusPakett) {
        pakett = uusPakett;
    }
    public void teineMudel(String paremMudel) {
        mudel = paremMudel;
    }
}
