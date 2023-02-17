package olter.balls.database.languages;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<LanguageEntity, Integer> {
	LanguageEntity findByName(String name);
}
