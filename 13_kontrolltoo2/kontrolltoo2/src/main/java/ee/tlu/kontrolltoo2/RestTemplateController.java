package ee.tlu.kontrolltoo2;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// https://marineregions.org/rest/getGazetteerTypes.json
// https://environment.data.gov.uk/flood-monitoring/id/floods
@RestController
public class RestTemplateController {
    @GetMapping("/rivers-kirjeldus/{type}")
    public List<String> riversKirjeldus(@PathVariable String type) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RestTemplateRiver[]> response = restTemplate.exchange(
                "https://marineregions.org/rest/getGazetteerTypes.json?type=" + type,
                HttpMethod.GET,
                null,
                RestTemplateRiver[].class
        );

        List<String> descriptions = new ArrayList<>();
        for (RestTemplateRiver river : response.getBody()) {
            descriptions.add(river.getDescription());
        }

        return descriptions;
    }

    @GetMapping("/rivers-ujutused/{name}")
    public List<FloodArea> riversUjutus(@PathVariable String name) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://environment.data.gov.uk/flood-monitoring/id/floods?eaAreaName=" + name;

        ResponseEntity<Yleujutused> response = restTemplate.exchange(url, HttpMethod.GET, null, Yleujutused.class);

        List<FloodArea> floodAreas = new ArrayList<>();
        if (response.getBody() != null) {
            List<Item> items = response.getBody().getItems();
            for (Item item : items) {
                floodAreas.add(item.getFloodArea());
            }
        }

        return floodAreas;
    }
}
