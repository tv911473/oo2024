package ee.tlu.kontrolltoo2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RiverRepository extends JpaRepository<River, Long> {

    River findFirstBySpeedNotNullOrderBySpeedDesc();

    River findFirstBySpeedNotNullOrderBySpeedAsc();
}
