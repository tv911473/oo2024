package ee.tlu.salat.repository;

import ee.tlu.salat.entity.ToiduKomponent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToiduKomponentRepository extends JpaRepository<ToiduKomponent, Long> {


//    List<ToiduKomponent> findByToit_Id(Long id);
}
