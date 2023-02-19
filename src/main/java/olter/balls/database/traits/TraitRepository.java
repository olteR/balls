package olter.balls.database.traits;

import java.util.Optional;
import olter.balls.database.traits.model.TraitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraitRepository extends JpaRepository<TraitEntity, Integer> {
  Optional<TraitEntity> findByName(String name);
}
