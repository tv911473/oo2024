package ee.tlu.salat.controller;

import ee.tlu.salat.entity.Toit;
import ee.tlu.salat.repository.ToitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToitController {

    @Autowired
    ToitRepository toitRepository;


    // localhost:8080/toit
    @GetMapping("toit")
    public List<Toit> getToidud() {
        return toitRepository.findAll();
    }
    // localhost:8080/toit/3
    @DeleteMapping("toit/{id}")
    public List<Toit> deleteToit(@PathVariable Long id) {
        toitRepository.deleteById(id);
        return toitRepository.findAll();
    }

    @PostMapping("toit")
    public List<Toit> addToit(@RequestBody Toit toit) {
        toitRepository.save(toit);
        return toitRepository.findAll();
    }
    /*function lisaToit() {
    const lisatavToit = {
        "toidukomponendid": [toidukomponentRef.current.value],
        "nimetus": nimetusRef.current.value
    }
        fetch("http://localhost:8080/toit",
                {
                "method": "POST",
                "body": JSON.stringify(lisatavToit),
                "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json())
      .then(json => {
                setToidud(json);
      })
    }*/
}
