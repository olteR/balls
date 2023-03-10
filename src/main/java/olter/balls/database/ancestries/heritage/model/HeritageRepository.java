package olter.balls.database.ancestries.heritage.model;

import java.util.Optional;
import olter.balls.database.ancestries.ancestry.model.AncestryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HeritageRepository extends JpaRepository<HeritageEntity, Integer> {
  Optional<HeritageEntity> findByName(String name);

  @Query("SELECT h FROM HeritageEntity h WHERE h.ancestry = ?1 AND h.name LIKE %?2%")
  Optional<HeritageEntity> findByAncestryAndShortName(AncestryEntity ancestry, String name);
}
