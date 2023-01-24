package olter.balls.campaigns;

import olter.balls.campaigns.dto.CampaignResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CampaignMapper {
    CampaignResponse entityToResponse(CampaignEntity entity);
}
