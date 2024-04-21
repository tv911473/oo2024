package ee.tlu.salat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Toit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nimetus;

    @ManyToMany
    List<ToiduKomponent> toidukomponendid;


}
// GenerationType.IDENTITY --> 1,2,3,4,5...
// GenerationType.SEQUENCE --> saan alustada kindalast numbrist ja liikuda edasi kindlate nubrite võrra
// GenerationType.UUID --> e58ed763-928c-4155-bee9-fdbaaadc15f3
// GenerationType.AUTO --> automaatselt Postgres enda seadisus
// GenerationType.TABLE -- > Googelda
