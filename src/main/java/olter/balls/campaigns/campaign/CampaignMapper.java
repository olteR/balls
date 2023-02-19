package olter.balls.campaigns.campaign;

import olter.balls.campaigns.campaign.dto.CampaignDetailsResponse;
import olter.balls.campaigns.campaign.dto.CampaignListResponse;
import olter.balls.campaigns.campaign.model.CampaignEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CampaignMapper {
  CampaignListResponse entityToListResponse(CampaignEntity entity);

  CampaignDetailsResponse entityToDetailsResponse(CampaignEntity entity);
}
