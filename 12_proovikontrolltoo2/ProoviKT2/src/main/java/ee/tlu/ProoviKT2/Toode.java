package ee.tlu.ProoviKT2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Toode {
    @Id // vajalik kui @Entity kasutusel
    @GeneratedValue(strategy = GenerationType.IDENTITY) // automaatne id genereerimine
    private Long id;
    private String nimi;
    private double hind;
    private boolean aktiivne;

    @ManyToOne // (SQL relation N:1) (mitu toodet ühele kategooriale)
    private Kategooria kategooria; // lisab Toode entityle Kategooria id ja seob selle tootega ära
}
