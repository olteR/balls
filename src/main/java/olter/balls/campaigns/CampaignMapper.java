package olter.balls.campaigns;

import olter.balls.campaigns.dto.CampaignResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CampaignMapper {
    CampaignResponse entityToResponse(CampaignEntity entity);
}
