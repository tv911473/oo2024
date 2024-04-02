package ee.tlu.Kodutoo4;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Table(name = "numbrid")
@Entity
@NoArgsConstructor
public class NumbriEntity {
    @Id
    String nimi;
    int teine;
    int kolmas;

}