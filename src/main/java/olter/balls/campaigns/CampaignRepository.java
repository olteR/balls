package olter.balls.campaigns;

import olter.balls.users.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<CampaignEntity, Integer> {

    @Query("SELECT ce FROM CampaignEntity ce LEFT JOIN UserEntity ue ON ce.gameMaster = ue WHERE ue.id = ?1")
    List<CampaignEntity> findAllByGameMasterId(Integer gameMasterId);
}
