package ee.tlu.salat.repository;

import ee.tlu.salat.entity.ToiduaineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToiduaineRepository extends JpaRepository<ToiduaineEntity, String> {
    // Siia saab kirjutada custom repository kaske, mis tagvastavad kas
    // ToiduaineEntity voi List<ToiduaineEntity>

    // SELECT * FROM Toiduained WHERE valk >= 5;
    // JPA Buddy
    List<ToiduaineEntity> findAllByValkGreaterThan(int valk);

    List<ToiduaineEntity> findAllBySysivesikBetween(int min, int max);

}
