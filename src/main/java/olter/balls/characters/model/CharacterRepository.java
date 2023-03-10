package olter.balls.characters.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {
  @Query("SELECT ce FROM CharacterEntity ce WHERE ce.owner.id = ?1")
  List<CharacterEntity> findAllByOwnerId(Long userId);
}
