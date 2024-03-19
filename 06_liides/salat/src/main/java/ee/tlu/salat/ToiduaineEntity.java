package ee.tlu.salat;

// jpa moodulist pärinev Hibernate.
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Table(name = "toiduaine") // tabeli nimi "toiduaine"
@Entity // anmebaasi panekuks
@NoArgsConstructor
public class ToiduaineEntity {
    @Id // alati unikaalne - kustutamiseks, võtmiseks, muutmiseks
    String nimetus;
    int valk;
    int rasv;
    int sysivesik;
}
