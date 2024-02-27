import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lugemine.txt"));
        String rida = br.readLine();
        while (rida != null) {
            System.out.println(rida);
            String[] sonad = rida.split(" "); // String[] on array
            System.out.println(Arrays.toString(sonad));

            double ruutu = Math.pow(sonad.length, 2);
            System.out.println(ruutu);

            double ruutjuur = Math.sqrt(sonad.length);
            System.out.println(ruutjuur);

            rida = br.readLine();
        }
    }
}