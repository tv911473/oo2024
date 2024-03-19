package ee.tlu.salat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api") // lisab "toiduained" ette "api"
public class ToiduaineEntityController {

    ToiduaineRepository toiduaineRepository;
    public ToiduaineEntityController(ToiduaineRepository toiduaineRepository) {
        this.toiduaineRepository = toiduaineRepository;
    }
//    @Autowired
//    ToiduaineRepository toiduaineRepository;
//    List<ToiduaineEntity> toiduained = new ArrayList<>(); // imiteerime andmebaasi

    // localhost:8080/api/toiduained
    @GetMapping("toiduained")
    public List<ToiduaineEntity> saaToiduained() {
        return toiduaineRepository.findAll();
    }

    // localhost:8080/api/toiduained/Vorst/15/5/1 POST.
    // Järjekord ON tähtis /Vorst/rasv/...
    // Ühtegi ei saa vahele jätta
    @PostMapping("toiduained/{nimi}/{valk}/{rasv}/{sysivesik}")
    public List<ToiduaineEntity> lisaToiduained(
            @PathVariable String nimetus,
            @PathVariable int valk,
            @PathVariable int rasv,
            @PathVariable int sysivesik
            ) {
        if (valk + rasv + sysivesik > 100) {
            return toiduaineRepository.findAll();
        }
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimetus, valk, rasv, sysivesik);
        toiduaineRepository.save(toiduaine);
        return toiduaineRepository.findAll();
    }

    // POST - Body - raw - JSON
    //{
    //"nimetus": "kapsas",
    //"valk": 2,
    //"rasv": 3,
    //"sysivesik": 4
    //}
    @PostMapping("toiduained")
    public List<ToiduaineEntity> lisaToiduained(@RequestBody ToiduaineEntity toiduaineEntity) {
        if (toiduaineEntity.valk + toiduaineEntity.rasv + toiduaineEntity.sysivesik > 100) {
            return toiduaineRepository.findAll();
        }
        // ToiduaineEntity toiduaine = new ToiduaineEntity(nimetus, valk, rasv, sysivesik);
        toiduaineRepository.save(toiduaineEntity);
        return toiduaineRepository.findAll();
    }

    @DeleteMapping("toiduained/{nimi}")
    public List<ToiduaineEntity> kustutaToiduained(@PathVariable String nimi) {
        toiduaineRepository.deleteById(nimi);
        return toiduaineRepository.findAll();
    }

    // localhost:8080/api/toiduained?index=0&nimi=Vorst&valk=20&rasv=1&sysivesik=12 PUT.
    @PutMapping("toiduained")
    public List<ToiduaineEntity> muudaToiduained(
            @RequestParam String nimi,
            @RequestParam int valk,
            @RequestParam int rasv,
            @RequestParam int sysivesik
            ) {
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        // toiduained.set(index, toiduaine);
        toiduaineRepository.save(toiduaine); // sama mis POST
        // Hibernate kontrollib kas sellise primaarvõtmega element on juba andmebaasis
        return toiduaineRepository.findAll();
    }
    @GetMapping("toiduained/{nimi}")
    public ToiduaineEntity saaYksToiduaine(@PathVariable String nimi) {
        return toiduaineRepository.findById(nimi).get();
    }

    @GetMapping("toiduainete-koguarv")
    public int toiduaineteKoguarv() {
        return toiduaineRepository.findAll().size();
    }

}

// 404 - URL ehk API otspunkt vale
// 4xx - Front-endi viga
// 5xx - Back-endi ehk serveri poolne viga