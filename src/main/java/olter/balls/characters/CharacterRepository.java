package olter.balls.characters;

import olter.balls.campaigns.CampaignEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Integer> {

    @Query(value = "SELECT ce.id, ce.name, ce.owner_id, ce.ruleset_id FROM characters ce LEFT JOIN campaign_characters cc ON ce.id = cc.character_id WHERE cc.campaign_id = :campaignId", nativeQuery = true)
    List<CharacterEntity> findAllCharactersByCampaignId(Integer campaignId);

    @Query("SELECT ce.campaigns FROM CharacterEntity ce WHERE ce.owner.id = ?1")
    List<CampaignEntity> findCampaignsByOwnerId(Integer ownerId);
}
