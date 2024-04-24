package ee.tlu.ProoviKT2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Toode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nimi;
    private double hind;
    private boolean aktiivne;

    @ManyToOne
    private Kategooria kategooria;
}
