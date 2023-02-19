package olter.balls.database.ancestries.ancestry.model;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AncestryRepository extends JpaRepository<AncestryEntity, Integer> {
  Optional<AncestryEntity> findByName(String name);
}
