//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Kolmnurk kolmnurk1 = new Kolmnurk(3.0, 3.0, 4.0);
        Kolmnurk kolmnurk2 = new Kolmnurk(2.5, 6.0, 7.2);

        double valjund1 = kolmnurk1.ymbermoot();
        System.out.printf("%.2f\n", valjund1);

        double valjund2 = kolmnurk2.pindala();
        System.out.printf("%.2f\n", valjund2);
    }
}