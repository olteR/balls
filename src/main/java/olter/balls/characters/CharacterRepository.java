package olter.balls.characters;

import olter.balls.connections.campaign_users.CampaignUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Integer> {
    @Query("SELECT ce FROM CharacterEntity ce WHERE ce.owner.id = ?1")
    List<CharacterEntity> findAllByOwnerId(Integer userId);
}
