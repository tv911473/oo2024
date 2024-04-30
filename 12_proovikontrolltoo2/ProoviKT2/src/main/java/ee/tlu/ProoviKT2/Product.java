package ee.tlu.ProoviKT2;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Product {
    public int id;
    public String title;
    public double price;
    public String description;
    public String category;
    public String image;
    public Rating rating; // Rating class
}