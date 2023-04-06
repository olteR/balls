package olter.balls.database.spells.model;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellRepository extends JpaRepository<SpellEntity, Long> {
  Optional<SpellEntity> findByName(String name);
}
