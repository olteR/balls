package olter.balls.database.languages.model;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<LanguageEntity, Integer> {
  Optional<LanguageEntity> findByName(String name);
}
