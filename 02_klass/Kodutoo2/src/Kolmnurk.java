public class Kolmnurk {
    double kylg1;
    double kylg2;
    double kylg3;

    public Kolmnurk(double kylg1, double kylg2, double kylg3) {
        this.kylg1 = kylg1;
        this.kylg2 = kylg2;
        this.kylg3 = kylg3;
    }
    public double ymbermoot() {
        return kylg1 + kylg2 + kylg3;
    }

    public double pindala() {
        double s = ymbermoot() / 2;
        return Math.sqrt(s * (s - kylg1) * (s - kylg2) * (s - kylg3));
    }

}
