package olter.balls.characters;

import olter.balls.campaigns.CampaignEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Integer> {
    @Query("SELECT ce.campaigns FROM CharacterEntity ce WHERE ce.owner.id = ?1")
    List<CampaignEntity> findCampaignsByOwnerId(Integer ownerId);
}
