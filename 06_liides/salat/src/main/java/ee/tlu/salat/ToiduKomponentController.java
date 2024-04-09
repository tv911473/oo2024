package ee.tlu.salat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToiduKomponentController {

    @Autowired
    ToiduKomponentRepository toiduKomponentRepository;

    // Bean ---> automaatselt loodav klass kuo rakendus käivitub (new Class();)

    // http://localhost:8080/toidukomponendid
    @GetMapping("toidukomponendid")
    public List<ToiduKomponent> getToiduKomponents() {
        return toiduKomponentRepository.findAll();
    }

    @DeleteMapping("toidukomponendid/{id}")
    public List<ToiduKomponent> deleteToiduKomponent(@PathVariable Long id) { // Long on ToiduKomponentRepository
        toiduKomponentRepository.deleteById(id);
        return toiduKomponentRepository.findAll();
    }
    // POST
    // {
    //    "toiduaine": {"nimetus": "test1"},
    //    "kogus": 100
    // }
    @PostMapping("toidukomponendid")
    public List<ToiduKomponent> postToiduKomponent(@RequestBody ToiduKomponent toiduKomponent) {
        toiduKomponentRepository.save(toiduKomponent);
        return toiduKomponentRepository.findAll();
    }
}
