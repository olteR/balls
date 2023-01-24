package olter.balls.connections.campaign_users;

import olter.balls.connections.campaign_users.dto.CampaignUserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CampaignUserMapper {
    CampaignUserResponse entityToResponse(CampaignUserEntity entity);
}