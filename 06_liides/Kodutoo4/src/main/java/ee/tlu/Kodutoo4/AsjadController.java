package ee.tlu.Kodutoo4;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AsjadController {
    List<String> asjad = new ArrayList<>();

    // kuva asjade listi brauseris
    // locahost:8080/asjad
    @GetMapping("asjad")
    public List<String> naitaAsju() {
        return asjad;
    }

    // lisa asju listi juurde
    @PostMapping("asjad/{asi}")
    public List<String> lisaAsju(@PathVariable String asi) {
        asjad.add(asi);
        return asjad;
    }

    // kustuta üks asi listist
    @DeleteMapping("asjad/{asi}")
    public List<String> kustutaAsi(@PathVariable String asi) {
        asjad.remove(asi);
        return asjad;
    }


    // arvuta mitu asja on listis
    // locahost:8080/asjade-koguarv
    @GetMapping("asjade-koguarv")
    public int mituAsja() {
        return asjad.size();
    }

    // arvuta listis olevate asjade kogusumma
    // locahost:8080/kogusumma
    @GetMapping("kogusumma")
    public double asjadeSumma() {
        double summa = 0;
        for (String asi : asjad) {
            summa += Double.parseDouble(asi);
        }
        return summa;
    }

    // arvuta listis olevate asjade keskmine
    @GetMapping("keskmine")
    public double asjadeKeskmine() {
        double summa = 0;
        for (String s : asjad) {
            summa += Double.parseDouble(s);
        }

        return summa / asjad.size();
    }
}
