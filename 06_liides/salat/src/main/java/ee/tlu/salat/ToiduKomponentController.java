package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ToiduKomponentController {
    List<ToiduKomponent> toidukomponendid = new ArrayList<>();

    // POST - Body - raw - JSON
    // {"toiduaine":
    //    {
    //    "nimetus": "kartul",
    //    "valk": 3,
    //    "rasv": 3,
    //    "sysivesik": 10
    //    },
    //    "kogus": 100
    // }
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
