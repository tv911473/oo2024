package ee.tlu.Kodutoo4;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class AsjadEntityController {
    AsjadRepository asjadRepository;
    public AsjadEntityController (AsjadRepository asjadRepository) {
        this.asjadRepository = asjadRepository;
    }

    // kuva asju listi brauseris
    // locahost:8080/asjad
    @GetMapping("asjad")
    public List<AsjadEntity> naitaAsju() {
        return asjadRepository.findAll();
    }

    // lisa asju listi juurde
    @PostMapping("asjad/{nimi}/{pikkus}/{kolmas}")
    public List<AsjadEntity> lisaAsju(
            @PathVariable String nimi,
            @PathVariable int pikkus,
            @PathVariable int kolmas
            ) {
        AsjadEntity sisend = new AsjadEntity(nimi, pikkus, kolmas);
        asjadRepository.save(sisend);
        return asjadRepository.findAll();
    }

    @PostMapping("asjad")
    public List<AsjadEntity> lisaAsju(@RequestBody AsjadEntity asjadEntity) {
        asjadRepository.save(asjadEntity);
        return asjadRepository.findAll();
    }

    // kustuta üks väärtus listist
    @DeleteMapping("asjad/{nimi}")
    public List<AsjadEntity> kustutaAsju(@PathVariable String nimi) {
        asjadRepository.deleteById(nimi);
        return asjadRepository.findAll();
    }

    // muuda üks väärtus listis
    @PutMapping("asjad")
    public List<AsjadEntity> muudaSisendit(
            @RequestParam String nimi,
            @RequestParam int pikkus,
            @RequestParam int kolmas
    ) {
        AsjadEntity sisend = new AsjadEntity(nimi, pikkus, kolmas);
        asjadRepository.save(sisend);
        return asjadRepository.findAll();
    }

    // arvuta listis olevate objektide numbrilised väärtused kokku
    @GetMapping("asjad-summa")
    public int mituAsja() {
        int summa = 0;
        List<AsjadEntity> asjad = asjadRepository.findAll();
        for (AsjadEntity sisend : asjad) {
            summa += sisend.pikkus + sisend.laius;
        }
        return summa;
    }
}
