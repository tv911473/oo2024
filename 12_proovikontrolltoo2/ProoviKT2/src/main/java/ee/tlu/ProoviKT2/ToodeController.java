package ee.tlu.ProoviKT2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Loo uus rakendus veebipood. Tee talle entity "Toode" entity, omadustega:
// Id (automaatselt genereeritud, nimetus String, hind double, aktiivne boolean),
//  tee talle Repository,
//kontroller, millega andmebaasi panna:
//         panna, võtta, kustutada
// kuva välja front-endis.
@RestController
@CrossOrigin(origins = "http://localhost:3000") // browseri jaoks
public class ToodeController {

    @Autowired // ühendus teise classiga, et funktsioone välja kutsuda (ToodeRepository)
    ToodeRepository toodeRepository; // toodeRepository on muutja nimi (voib olla suvaline)

    // localhost:8080/tooted
    @GetMapping("tooted")
    public List<Toode> getTooted() {
        return toodeRepository.findAll();
    }

//    POSTMAN raw JSON
//    {
//        "nimi": "toode",
//        "hind": 10,
//        "aktiivne": true,
//        "kategooria": 1      (kategooria id peab enne olema loodud)
//    }

    // localhost:8080/tooted
    @PostMapping("tooted")
    public List<Toode> postToode(@RequestBody Toode toode) {
        toodeRepository.save(toode);
        return toodeRepository.findAll();
    }

    @DeleteMapping("tooted/{id}")
    public List<Toode> deleteToode(@PathVariable Long id) { // Long id on Toode.java failis
        toodeRepository.deleteById(id);
        return toodeRepository.findAll();
    }

    // localhost:8080/toote-hind-vahemik/10/20
    @GetMapping("toote-hind-vahemik/{min}/{max}")
    public List<Toode> tooteHindVahemik(@PathVariable double min, @PathVariable double max) {
        return toodeRepository.findByHindBetween(min, max);
    }

    @GetMapping("max-hinnaga-toode")
    public Toode maxHinnagaToode() {
        return toodeRepository.findFirstByHindNotNullOrderByHindDesc(); // ToodeRepository sees
    }
}
