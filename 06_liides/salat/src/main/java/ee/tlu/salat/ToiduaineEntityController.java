package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api") // lisab "toiduained" ette "api"
public class ToiduaineEntityController {
    List<ToiduaineEntity> toiduained = new ArrayList<>(); // imiteerime andmebaasi

    // localhost:8080/api/toiduained
    @GetMapping("toiduained")
    public List<ToiduaineEntity> saaToiduained() {
        return toiduained;
    }

    // localhost:8080/api/toiduained/Vorst/15/5/1 POST.
    // Järjekord ON tähtis /Vorst/rasv/...
    // Ühtegi ei saa vahele jätta
    @PostMapping("toiduained/{nimi}/{valk}/{rasv}/{sysivesik}")
    public List<ToiduaineEntity> lisaToiduained(
            @PathVariable String nimi,
            @PathVariable int valk,
            @PathVariable int rasv,
            @PathVariable int sysivesik
            ) {
        if (valk + rasv + sysivesik > 100) {
            return toiduained;
        }
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduained.add(toiduaine);
        return toiduained;

    }

    @DeleteMapping("toiduained/{index}")
    public List<ToiduaineEntity> kustutaToiduained(@PathVariable int index) {
        toiduained.remove(index);
        return toiduained;
    }

    // localhost:8080/api/toiduained?index=0&nimi=Vorst&valk=20&rasv=1&sysivesik=12 PUT.
    @PutMapping("toiduained")
    public List<ToiduaineEntity> muudaToiduained(
            @RequestParam int index,
            @RequestParam String nimi,
            @RequestParam int valk,
            @RequestParam int rasv,
            @RequestParam int sysivesik
            ) {
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduained.set(index, toiduaine);
        return toiduained;
    }
    @GetMapping("toiduained/{index}")
    public ToiduaineEntity saaYksToiduaine(@PathVariable int index) {
        return toiduained.get(index);
    }

    @GetMapping("toiduainete-koguarv")
    public int toiduaineteKoguarv() {
        return toiduained.size();
    }

}

// 404 - URL ehk API otspunkt vale
// 4xx - Front-endi viga
// 5xx - Back-endi ehk serveri poolne viga