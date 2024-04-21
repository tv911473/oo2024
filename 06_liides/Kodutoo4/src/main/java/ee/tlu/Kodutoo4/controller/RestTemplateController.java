package ee.tlu.Kodutoo4.controller;

import ee.tlu.Kodutoo4.model.CoinDesk;
import ee.tlu.Kodutoo4.model.Currency;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RestTemplateController {
    @GetMapping("saa-bitcoini-hind")
    public CoinDesk getBitcoinPrice() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
        ResponseEntity<CoinDesk> response = restTemplate.exchange(url, HttpMethod.GET, null, CoinDesk.class);
        return response.getBody();
    }

    @GetMapping("saa-bitcoini-hind/{currency}")
    public Currency getBitcoinPriceBycurrency(@PathVariable String currency) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
        ResponseEntity<CoinDesk> response = restTemplate.exchange(url, HttpMethod.GET, null, CoinDesk.class);

        return switch (currency) {
            case "USD" -> response.getBody().getBpi().getUSD();
            case "GBP" -> response.getBody().getBpi().getGBP();
            case "EUR" -> response.getBody().getBpi().getEUR();
            default -> throw new IllegalArgumentException("Invalid currency: " + currency);
        };
    }
}
