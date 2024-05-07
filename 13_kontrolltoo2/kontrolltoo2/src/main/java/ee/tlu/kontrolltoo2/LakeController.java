package ee.tlu.kontrolltoo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LakeController {
    @Autowired
    LakeRepository lakeRepository;


    @GetMapping("lakes")
    public List<Lake> getLakes() {
        return lakeRepository.findAll();
    }

    // localhost:8080/rivers
    @PostMapping("lakes")
    public List<Lake> postLake(@RequestBody Lake lake) {
        lakeRepository.save(lake);
        return lakeRepository.findAll();
    }

    @DeleteMapping("lakes/{id}")
    public List<Lake> deleteLake(@PathVariable Long id) {
        lakeRepository.deleteById(id);
        return lakeRepository.findAll();
    }

}
