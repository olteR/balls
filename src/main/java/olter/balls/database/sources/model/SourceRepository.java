package olter.balls.database.sources.model;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepository extends JpaRepository<SourceEntity, Long> {
  Optional<SourceEntity> findByShortName(String shortName);
}
