package olter.balls.database.sources;

import olter.balls.common.NameResponse;
import olter.balls.database.importer.dto.SourceImport;
import olter.balls.database.sources.dto.SourceListResponse;
import olter.balls.database.sources.model.SourceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SourceMapper {
  NameResponse entityToNameResponse(SourceEntity entity);

  SourceListResponse entityToListResponse(SourceEntity entity);

  @Mapping(target = "id", ignore = true)
  SourceEntity map(SourceImport source, @MappingTarget SourceEntity target);
}
