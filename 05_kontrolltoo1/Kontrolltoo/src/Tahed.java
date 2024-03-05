import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tahed {
    public int loendaTahti(String laused) throws IOException {
        int valjund = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(laused))) {
            String rida;
            while ((rida = br.readLine()) != null) {
                valjund += loendaATahed(rida);
            }
        }
        return valjund;
    }

    private int loendaATahed(String rida) {
        int loenda = 0;
        for (char c : rida.toCharArray()) {
            if (c == 'a' || c == 'A') {
                loenda++;
            }
        }
        return loenda;
    }
}