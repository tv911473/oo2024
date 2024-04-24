package ee.tlu.ProoviKT2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Loo uus rakendus veebipood. Tee talle entity "Toode", omadustega:
// Id (automaatselt genereeritud, nimetus String, hind double, aktiivne boolean),
//  tee talle Repository,
//kontroller, millega andmebaasi panna:
//         panna, võtta, kustutada
// kuva välja front-endis.
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToodeController {

    @Autowired
    ToodeRepository toodeRepository;

    @GetMapping("tooted")
    public List<Toode> getTooted() {
        return toodeRepository.findAll();
    }

    @PostMapping("tooted")
    public List<Toode> postToode(@RequestBody Toode toode) {
        toodeRepository.save(toode);
        return toodeRepository.findAll();
    }

    @DeleteMapping("tooted/{id}")
    public List<Toode> deleteToode(@PathVariable Long id) {
        toodeRepository.deleteById(id);
        return toodeRepository.findAll();
    }

    @GetMapping("toote-hind-vahemik/{min}/{max}")
    public List<Toode> tooteHindVahemik(@PathVariable double min, @PathVariable double max) {
        return toodeRepository.findByHindBetween(min, max);
    }

    @GetMapping("max-hinnaga-toode")
    public Toode maxHinnagaToode() {
        return toodeRepository.findFirstByHindNotNullOrderByHindDesc();
    }
}
