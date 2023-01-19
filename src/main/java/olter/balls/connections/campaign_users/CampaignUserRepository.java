package olter.balls.connections.campaign_users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignUserRepository extends JpaRepository<CampaignUserEntity, Integer> {
    @Query("SELECT cu FROM CampaignUserEntity cu WHERE cu.user.id = ?1")
    List<CampaignUserEntity> findAllByUserId(Integer userId);
}
