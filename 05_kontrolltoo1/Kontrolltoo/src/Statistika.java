import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Statistika {
    private int aTahtedeArv;
    private int sonadeArv;
    private int tahtedeArv;
    private Map<Integer, Integer> aTahtedeIgasSonas;
    private Map<Integer, Integer> sonadeArvAga;

    public void arvuta(String failinimi) throws IOException {
        aTahtedeArv = 0;
        sonadeArv = 0;
        tahtedeArv = 0;
        Map<Integer, Integer> aTahtedeArvSonas = new HashMap<>();
        aTahtedeIgasSonas = new HashMap<>();
        sonadeArvAga = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(failinimi))) {
            String rida;
            while ((rida = br.readLine()) != null) {
                String[] sonad = rida.split(" ");
                boolean onLeitud = false;
                for (String sona : sonad) {
                    int aSonas = (int) sona.toLowerCase().chars().filter(c -> c == 'a').count();
                    aTahtedeArv += aSonas;
                    tahtedeArv += sona.length();
                    sonadeArv++;
                    aTahtedeArvSonas.putIfAbsent(aSonas, 0);
                    aTahtedeArvSonas.put(aSonas, aTahtedeArvSonas.get(aSonas) + 1);

                    // Lisa igasse sõnasse a-tähtede arv
                    aTahtedeIgasSonas.put(sonadeArv, aSonas);

                    // Suurenda vastavat väärtust sonadeArvAga's
                    if (aSonas > 0) {
                        onLeitud = true;
                        sonadeArvAga.putIfAbsent(aSonas, 0);
                        sonadeArvAga.put(aSonas, sonadeArvAga.get(aSonas) + 1);
                    }
                }
                // Kui vähemalt ühes sõnas leiti 'a'-tähti, suurenda ka sonade arvu vastavas arvus 'a'-tähtedega
                if (onLeitud) {
                    sonadeArvAga.putIfAbsent(0, 0);
                    sonadeArvAga.put(0, sonadeArvAga.get(0) + 1);
                }
            }
        }
    }

    public void prindi() {
        System.out.println("Sõnades keskmiselt a-tähti: " + getKeskmineA());
        System.out.println("A-tähtede suhtarv tähtede üldarvuga: " + getSuhtarv());
        System.out.println("A-tähtede arv iga sõna kohta: ");
        for (Map.Entry<Integer, Integer> entry : aTahtedeIgasSonas.entrySet()) {
            System.out.println("Sõna " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public double getKeskmineA() {
        return (double) aTahtedeArv / sonadeArv;
    }

    public double getSuhtarv() {
        return (double) aTahtedeArv / tahtedeArv;
    }

    public void looTabel(String sisendFail, String valjundFail) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(sisendFail));
             BufferedWriter bw = new BufferedWriter(new FileWriter(valjundFail))) {

            String rida;
            while ((rida = br.readLine()) != null) {
                String[] sonad = rida.split(" ");
                for (String sona : sonad) {
                    int tahtiKokku = sona.length();
                    int aTahti = (int) sona.toLowerCase().chars().filter(c -> c == 'a').count();

                    bw.write(String.format("%-15s %-15s %-15s", sona, tahtiKokku, aTahti));
                    bw.newLine();
                }
            }
            // Lisa tabelisse ka sonade arv 'a'-tähtedega
            bw.write("Sonade arv 'a'-tähtedega:");
            bw.newLine();
            for (Map.Entry<Integer, Integer> entry : sonadeArvAga.entrySet()) {
                bw.write(entry.getKey() + " a-tähte: " + entry.getValue() + " sõna.");
                bw.newLine();
            }
        }
    }
}
