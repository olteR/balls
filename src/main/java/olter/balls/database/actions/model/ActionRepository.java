package olter.balls.database.actions.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActionRepository extends JpaRepository<ActionEntity, Long> {
    Optional<ActionEntity> findByName(String name);
}
