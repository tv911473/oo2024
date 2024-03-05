import java.io.IOException;
//* Loe programmi abil kokku, kui palju on tekstifailis a-tähti (nii suuri kui väikeseid). Kokku lugemiseks kasuta omaloodud klassi välja kutsutud funktsiooni.
//* Leia, kui palju oli a-tähti igas sõnas, sõnades keskmiselt, suhtarvuna tähtede üldarvu ning pane nad klassi muutujatesse. Kuva välja "sout" abil ning kirjuta ka tulem tekstifaili.
//* Loe kokku, mitu sõna oli ühe, kahe, kolme jne a-tähega. Koosta tekstifaili lihtsakoeline tabel, kus ridadeks tähtede arv sõnas ning veergudeks a-tähtede arv. Lahtris näidatakse, mitu vastavat sõna oli tekstis.


public class Main {
    public static void main(String[] args) throws IOException {
        Tahed tahed = new Tahed();
        int valjund = tahed.loendaTahti("Laused.txt");
        System.out.println("Tekstifailis on " + valjund + " a-tähte.");

        String failinimi = "Laused.txt";
        Statistika statistika = new Statistika();
        statistika.arvuta(failinimi);
        statistika.prindi();

        statistika.looTabel("Laused.txt", "Tabel.txt");
    }
}

