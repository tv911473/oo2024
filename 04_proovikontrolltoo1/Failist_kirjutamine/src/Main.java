import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("valjund.txt"));
        pw.println("esimene rida");
        pw.println("teine rida");
        pw.println("kolmas rida");
        pw.print("yksik");
        pw.print(" ");
        pw.print("sona");
        pw.close();
    }
}