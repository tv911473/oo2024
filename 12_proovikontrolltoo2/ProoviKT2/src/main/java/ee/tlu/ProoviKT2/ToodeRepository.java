package ee.tlu.ProoviKT2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToodeRepository extends JpaRepository<Toode, Long> { // Long id on Toode.java failis

    // üks Toode (Find Instance) või List<Toode> (Find Collection)
    // JPA Designer (paremal menu ribal)

    // hinnavahemik.
    List<Toode> findByHindBetween(double hindStart, double hindEnd); // aseta ToodeController sisse

    // suurim hind
    Toode findFirstByHindNotNullOrderByHindDesc(); // aseta ToodeController sisse

    // leia kategooria id järgi
    List<Toode> findByKategooria_Id(Long id);



    // sisaldab tähte
    List<Toode> findByNimiContains(String nimi);

    // algab tähega
    Toode findByNimiStartsWith(String nimi);

}