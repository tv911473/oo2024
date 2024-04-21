package ee.tlu.Kodutoo4;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Table(name = "asjad")
@Entity
@NoArgsConstructor
public class AsjadEntity {
    @Id
    String nimi;
    int pikkus;
    int laius;

}