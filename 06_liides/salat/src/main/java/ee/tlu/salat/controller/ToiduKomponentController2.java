package ee.tlu.salat.controller;

import ee.tlu.salat.entity.ToiduKomponent;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToiduKomponentController2 {
    List<ToiduKomponent> toidukomponendid = new ArrayList<>();

    @PostMapping("toidukomponent")
    public List<ToiduKomponent> lisaToidukomponent(@RequestBody ToiduKomponent komponent) {
        toidukomponendid.add(komponent);
        return toidukomponendid;
    }

    @PutMapping("toidukomponent/{index}")
    public List<ToiduKomponent> muudaToidukomponent(@PathVariable int index, @RequestBody ToiduKomponent komponent) {
        toidukomponendid.add(index, komponent);
        return toidukomponendid;
    }
}
