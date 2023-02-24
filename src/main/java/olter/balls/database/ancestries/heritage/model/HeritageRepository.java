package olter.balls.database.ancestries.heritage.model;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeritageRepository extends JpaRepository<HeritageEntity, Integer> {
  Optional<HeritageEntity> findByName(String name);
}
