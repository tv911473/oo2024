package ee.tlu.salat.entity;

import ee.tlu.salat.entity.ToiduaineEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ToiduKomponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne // (cascade = CascadeType.ALL) // kui kustutatakse toiduaine, siis kustuvad ka seotud toidukomponendid
    ToiduaineEntity toiduaine;

//    @ManyToOne
//    Toit toit;


    // @ManyToMany
    // List<ToiduaineEntity> toiduained;
    int kogus;

    // {id: 5, toiduaine: {nimetus: "test"}, kogus: 100}
    // 5    |   "test"  |   100

}
