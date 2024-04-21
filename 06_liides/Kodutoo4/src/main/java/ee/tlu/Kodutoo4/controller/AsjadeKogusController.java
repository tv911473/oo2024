package ee.tlu.Kodutoo4.controller;

import ee.tlu.Kodutoo4.entity.AsjadeKogus;
import ee.tlu.Kodutoo4.repository.AsjadeKogusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class AsjadeKogusController {
    @Autowired
    AsjadeKogusRepository asjadeKogusRepository;
    @GetMapping("asjadekogus")
    public List<AsjadeKogus> getAsjadeKogused() {
        return asjadeKogusRepository.findAll();
    }
    @DeleteMapping("asjadekogus/{id}")
    public List<AsjadeKogus> deleteToidukomponent(@PathVariable Long id) {
        asjadeKogusRepository.deleteById(id);
        return asjadeKogusRepository.findAll();
    }
    @PostMapping("asjadekogus")
    public List<AsjadeKogus> addToidukomponent(@RequestBody AsjadeKogus asjadeKogus) {
        asjadeKogusRepository.save(asjadeKogus);
        return asjadeKogusRepository.findAll();
    }
}
