package olter.balls.database.actions.model;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<ActionEntity, Long> {
  Optional<ActionEntity> findByName(String name);
}
