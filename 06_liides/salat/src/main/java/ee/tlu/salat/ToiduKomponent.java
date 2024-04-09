package ee.tlu.salat;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ToiduKomponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    ToiduaineEntity toiduaine;
    int kogus;
    // @ManyToMany
    // List<ToiduaineEntity> toiduained;


    // {id: 5, toiduaine: {nimetus: "test"}, kogus: 100}
    // 5    |   "test"  |   100

}
