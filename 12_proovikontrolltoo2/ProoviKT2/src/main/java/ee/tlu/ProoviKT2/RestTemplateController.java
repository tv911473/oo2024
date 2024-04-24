package ee.tlu.ProoviKT2;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://fakestoreapi.com/products
// https://reqres.in/api/users
@RestController
public class RestTemplateController {

    @GetMapping("hankija-tooted")
    public List<Product> hankijaTooted() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Product[]> response = restTemplate
                .exchange("https://fakestoreapi.com/products", HttpMethod.GET, null, Product[].class);

        return Arrays.asList(response.getBody());
    }

    @GetMapping("hankija-tooted/{reiting}")
    public List<Product> hankijaTootedKindlaReitinguga(@PathVariable double reiting) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Product[]> response = restTemplate
                .exchange("https://fakestoreapi.com/products", HttpMethod.GET, null, Product[].class);

        List<Product> sobilikudTooted = new ArrayList<>();
        for (Product p : response.getBody()) {
            if (p.rating.rate > reiting) {
                sobilikudTooted.add(p);
            }
        }

        return sobilikudTooted;
    }
}