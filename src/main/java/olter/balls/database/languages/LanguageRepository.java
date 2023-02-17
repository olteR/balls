package olter.balls.database.languages;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<LanguageEntity, Integer> {
  Optional<LanguageEntity> findByName(String name);
}
