package ee.tlu.kontrolltoo2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@NoArgsConstructor
public class Yleujutused {
    @JsonProperty("@context")
    public String context;
    public Meta meta;
    public ArrayList<Item> items;
}
