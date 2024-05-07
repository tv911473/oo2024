package ee.tlu.ProoviKT2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

// import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Kategooria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nimi;

    // @ManyToMany --> teeb kahe tabeli siduvuse Toode_id ja Kategooria_id kaudu( tabel - Toode_Kategooria. (SQL relation N:M))
    // List<Toode> tooted;
}

