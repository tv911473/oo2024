package ee.tlu.ProoviKT2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToodeRepository extends JpaRepository<Toode, Long> {
    // Toode   või  List<Toode>

    //List<Toode> findByHindBetween(double hindStart, double hindEnd);
    List<Toode> findByHindBetween(double hindStart, double hindEnd);

    Toode findFirstByHindNotNullOrderByHindDesc();

    List<Toode> findByNimiContains(String nimi);

    List<Toode> findByNimiStartsWith(String nimi);


}