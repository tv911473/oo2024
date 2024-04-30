package ee.tlu.ProoviKT2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // browseri jaoks
public class KategooriaController {

    @Autowired
    KategooriaRepository kategooriaRepository; // saame andmebaasi funktsioone teha
    @Autowired
    ToodeRepository toodeRepository;

    @GetMapping("kategooriad")
    public List<Kategooria> getKategooriad() {
        return kategooriaRepository.findAll();
    }

//    POSTMAN raw JSON
//    {
//        "nimi": "toode",
//        "hind": 10,
//        "aktiivne": true,
//        "kategooria": 1      (kategooria id peab enne olema loodud)
//    }

    // localhost:8080/tooted
    @PostMapping("kategooriad")
    public List<Kategooria> postKategooria(@RequestBody Kategooria kategooria) {
        kategooriaRepository.save(kategooria);
        return kategooriaRepository.findAll();
    }

    @DeleteMapping("kategooriad/{id}")
    public List<Kategooria> deleteKategooria(@PathVariable Long id) { // Long id on Toode.java failis
        kategooriaRepository.deleteById(id);
        return kategooriaRepository.findAll();
    }

    @GetMapping("kategooria-tooted/{id}")
    public List<Toode> getKategooriaTooted(@PathVariable Long id) {
        return toodeRepository.findByKategooria_Id(id);
    }

    @GetMapping("kategooria-tooted-kokku/{id}")
    public double sumKategooriaTooted(@PathVariable Long id) {
//        double sum = 0;
//        for (Toode t :toodeRepository.findByKategooria_Id(id)) {
//            sum += t.getHind();
//        }
//        return sum;

        // sama variant kui for tsükkel
        return toodeRepository.findByKategooria_Id(id).stream().mapToDouble(Toode::getHind).sum();
    }
}
