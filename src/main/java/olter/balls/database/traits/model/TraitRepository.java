package olter.balls.database.traits.model;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraitRepository extends JpaRepository<TraitEntity, Integer> {
  Optional<TraitEntity> findByName(String name);
}
