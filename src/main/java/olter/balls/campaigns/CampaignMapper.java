package olter.balls.campaigns;

import olter.balls.campaigns.dto.CampaignDetailsResponse;
import olter.balls.campaigns.dto.CampaignListResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CampaignMapper {
	CampaignListResponse entityToListResponse(CampaignEntity entity);

	CampaignDetailsResponse entityToDetailsResponse(CampaignEntity entity);
}
