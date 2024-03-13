package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ToiduaineController {
    List<String> toiduained = new ArrayList<>(); // imiteerime andmebaasi

    // localhost:8080/saa-toiduained --> []
    @GetMapping("toiduained")
    public List<String> saaToiduained() {
        return toiduained;
    }

    // PostMappingut ei saa brauser teha
    // "Postman" --> localhost:8080/toiduained/Kartul --> POST.
    @PostMapping("toiduained/{toiduaine}")
    public List<String> lisaToiduained(@PathVariable String toiduaine) {
        toiduained.add(toiduaine);
        return toiduained;

    }
    // DeleteMappingut ei saa brauser teha
    // “Postman”, localhost:8080/toiduained/0 --> DELETE.
    @DeleteMapping("toiduained/{index}")
    public List<String> kustutaToiduained(@PathVariable int index) {
        toiduained.remove(index);
        return toiduained;
    }

    // PutMappingut ei saa brauser teha
    // “Postman”, localhost:8080/toiduained/0 --> PUT.
    @PutMapping("toiduained/{index}/{newValue}")
    public List<String> muudaToiduained(@PathVariable int index, @PathVariable String newValue) {
        toiduained.set(index, newValue);
        return toiduained;
    }
    @GetMapping("toiduained/{index}")
    public String saaYksToiduaine(@PathVariable int index) {
        return toiduained.get(index);
    }

    // localhost:8080/tere/mingi_nimi
    @GetMapping("tere/{nimi}")
    public String hello(@PathVariable String nimi) {
        return "Tere " + nimi;
    }

    // localhost:8080/korruta/2/3
    @GetMapping("korruta/{arv1}/{arv2}")
    public int multiply(@PathVariable int arv1, @PathVariable int arv2) {
        return arv1 * arv2;
    }
}

// 404 - URL ehk API otspunkt vale
// 4xx - Front-endi viga
// 5xx - Back-endi ehk serveri poolne viga