package ee.tlu.Kodutoo4.entity;

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
    private String nimi;
    private int pikkus;
    private int laius;

}