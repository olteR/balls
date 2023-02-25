package olter.balls.database.ancestries.heritage;

import olter.balls.common.NameResponse;
import olter.balls.database.ancestries.heritage.model.HeritageEntity;
import olter.balls.database.importer.dto.ancestry.HeritageImport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface HeritageMapper {
  NameResponse entityToNameResponse(HeritageEntity entity);

  @Mapping(target = "description", ignore = true)
  HeritageEntity map(HeritageImport source, @MappingTarget HeritageEntity target);
}
