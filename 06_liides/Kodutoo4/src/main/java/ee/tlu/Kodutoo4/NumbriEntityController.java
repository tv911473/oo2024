package ee.tlu.Kodutoo4;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NumbriEntityController {
    NumbriRepository numbriRepository;
    public NumbriEntityController (NumbriRepository numbriRepository) {
        this.numbriRepository = numbriRepository;
    }

    // kuva numbrite listi brauseris
    // locahost:8080/numbrid
    @GetMapping("numbrid")
    public List<NumbriEntity> naitaNumbreid() {
        return numbriRepository.findAll();
    }

    // lisa numbreid listi juurde
    @PostMapping("numbrid/{nimi}/{teine}/{kolmas}")
    public List<NumbriEntity> lisaNumbreid(
            @PathVariable String nimi,
            @PathVariable int teine,
            @PathVariable int kolmas
            ) {
        NumbriEntity sisend = new NumbriEntity(nimi, teine, kolmas);
        numbriRepository.save(sisend);
        return numbriRepository.findAll();
    }

    // kustuta üks väärtus listist
    @DeleteMapping("numbrid/{nimi}")
    public List<NumbriEntity> kustutaNumber(@PathVariable String nimi) {
        numbriRepository.deleteById(nimi);
        return numbriRepository.findAll();
    }

    // muuda üks väärtus listis
    @PutMapping("numbrid")
    public List<NumbriEntity> muudaSisendit(
            @RequestParam String nimi,
            @RequestParam int teine,
            @RequestParam int kolmas
    ) {
        NumbriEntity sisend = new NumbriEntity(nimi, teine, kolmas);
        numbriRepository.save(sisend);
        return numbriRepository.findAll();
    }

    // arvuta listis olevate objektide numbrilised väärtused kokku
    @GetMapping("numbrid-summa")
    public int mituNumbrit() {
        int summa = 0;
        List<NumbriEntity> numbrid = numbriRepository.findAll();
        for (NumbriEntity sisend : numbrid) {
            summa += sisend.teine + sisend.kolmas;
        }
        return summa;
    }
}
