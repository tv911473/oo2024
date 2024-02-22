public class Auto {
    Andmed andmed;
    int hind;
    String esindus;

    public Auto(Andmed andmed, int hind, String esindus) {
        this.andmed = andmed;
        this.hind = hind;
        this.esindus = esindus;
    }
    public void kampaania(int kampaaniHind) {
        this.hind -= kampaaniHind;
    }
    public void teineEsindus(String uusEsindus) {
        this.esindus = uusEsindus;
    }
}
