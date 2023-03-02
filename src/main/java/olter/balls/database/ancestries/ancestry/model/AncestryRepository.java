package olter.balls.database.ancestries.ancestry.model;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AncestryRepository extends JpaRepository<AncestryEntity, Long> {
  Optional<AncestryEntity> findByName(String name);
}
