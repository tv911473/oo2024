package ee.tlu.Kodutoo4;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NumbriEntityController {
    List<NumbriEntity> numbrid = new ArrayList<>();

    // kuva numbrite listi brauseris
    // locahost:8080/numbrid
    @GetMapping("numbrid")
    public List<NumbriEntity> naitaNumbreid() {
        return numbrid;
    }

    // lisa numbreid listi juurde
    @PostMapping("numbrid/{esimene}/{teine}/{kolmas}")
    public List<NumbriEntity> lisaNumbreid(
            @PathVariable int esimene,
            @PathVariable int teine,
            @PathVariable int kolmas
            ) {
        NumbriEntity sisend = new NumbriEntity(esimene, teine, kolmas);
        numbrid.add(sisend);
        return numbrid;
    }

    // kustuta üks väärtus listist
    @DeleteMapping("numbrid/{index}")
    public List<NumbriEntity> kustutaNumber(@PathVariable int index) {
        numbrid.remove(index);
        return numbrid;
    }

    // muuda üks väärtus listis
    @PutMapping("numbrid")
    public List<NumbriEntity> muudaSisendit(
            @RequestParam int index,
            @RequestParam int esimene,
            @RequestParam int teine,
            @RequestParam int kolmas
    ) {
        NumbriEntity sisend = new NumbriEntity(esimene, teine, kolmas);
        numbrid.set(index, sisend);
        return numbrid;
    }

    // arvuta listis olevate objektide numbrilised väärtused kokku
    @GetMapping("numbrid-summa")
    public int mituNumbrit() {
        int summa = 0;
        for (NumbriEntity sisend : numbrid) {
            summa += sisend.esimene + sisend.teine + sisend.kolmas;
        }
        return summa;
    }


}
