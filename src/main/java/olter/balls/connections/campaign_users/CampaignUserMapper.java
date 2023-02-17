package olter.balls.connections.campaign_users;

import olter.balls.connections.campaign_users.dto.CampaignUserListResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CampaignUserMapper {
	CampaignUserListResponse entityToResponse(CampaignUserEntity entity);
}
