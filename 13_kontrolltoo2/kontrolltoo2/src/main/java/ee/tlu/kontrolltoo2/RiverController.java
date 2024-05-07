package ee.tlu.kontrolltoo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RiverController {
    @Autowired
    RiverRepository riverRepository;


    @GetMapping("rivers")
    public List<River> getRivers() {
        return riverRepository.findAll();
    }

    // localhost:8080/rivers
    @PostMapping("rivers")
    public List<River> postRiver(@RequestBody River river) {
        riverRepository.save(river);
        return riverRepository.findAll();
    }

    @DeleteMapping("rivers/{id}")
    public List<River> deleteRiver(@PathVariable Long id) {
        riverRepository.deleteById(id);
        return riverRepository.findAll();
    }

    @GetMapping("rivers-pikkus/{id}")
    public double getRiverLength(@PathVariable Long id) {

        River river = riverRepository.findById(id).orElseThrow(() -> new RuntimeException("Jõge ei leitud id: " + id));

        double startX = river.getStart_x();
        double startY = river.getStart_y();
        double endX = river.getEnd_x();
        double endY = river.getEnd_y();

        return Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
    }

    @GetMapping("rivers-kiireim")
    public River getRiversKiireim() {
        return riverRepository.findFirstBySpeedNotNullOrderBySpeedDesc();
    }

    @GetMapping("rivers-aeglaseim")
    public River getRiversAeglaseim() {
        return riverRepository.findFirstBySpeedNotNullOrderBySpeedAsc();
    }

}
