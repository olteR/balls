package olter.balls.database.ancestries.heritage.model;

import olter.balls.database.ancestries.ancestry.model.AncestryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeritageRepository extends JpaRepository<HeritageEntity, Integer> {
    Optional<HeritageEntity> findByName(String name);
}
