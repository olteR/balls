package olter.balls.database.importer;

import olter.balls.database.ancestries.AncestryEntity;
import olter.balls.database.books.BookEntity;
import olter.balls.database.ancestries.AncestryRarityEnum;
import olter.balls.database.core.enums.CreatureSizeEnum;
import olter.balls.database.languages.LanguageTypeEnum;
import olter.balls.database.traits.TraitCategoryEnum;
import olter.balls.database.importer.dto.ancestry.AncestryImport;
import olter.balls.database.importer.dto.BookImport;
import olter.balls.database.importer.dto.LanguageImport;
import olter.balls.database.importer.dto.TraitImport;
import olter.balls.database.languages.LanguageEntity;
import olter.balls.database.traits.TraitEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ImportMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "speed.walking", source = "speed.walk")
    @Mapping(target = "speed.swimming", source = "speed.swim")
    AncestryEntity toAncestryEntity(AncestryImport ancestry);

    @EnumMapping(nameTransformationStrategy = "case", configuration = "lower")
    CreatureSizeEnum sizeToEnum(String size);

    @EnumMapping(nameTransformationStrategy = "case", configuration = "lower")
    AncestryRarityEnum rarityToEnum(String size);

    @Mapping(target = "id", ignore = true)
    BookEntity toBookEntity(BookImport book);

    @EnumMapping(nameTransformationStrategy = "case", configuration = "capital")
    @ValueMapping(source = MappingConstants.ANY_REMAINING, target = "COMMON")
    LanguageTypeEnum typeToEnum(String type);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ancestriesKnowing", ignore = true)
    @Mapping(target = "ancestriesAsAdditional", ignore = true)
    LanguageEntity toLanguageEntity(LanguageImport language);

    @ValueMapping(source = "Ancestry & Heritage", target = "ANCESTRY")
    @ValueMapping(source = "Action & Ability", target = "ACTION")
    @ValueMapping(source = "Creature", target = "CREATURE_TYPE")
    @ValueMapping(source = "Creature Type", target = "CREATURE_TYPE")
    @ValueMapping(source = "Energy & Element", target = "ENERGY")
    //@ValueMapping(source = MappingConstants.ANY_REMAINING, target = "GENERAL")
    @EnumMapping(nameTransformationStrategy = "case", configuration = "capital")
    TraitCategoryEnum categoryToEnum(String category);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "description", ignore = true)
    TraitEntity toTraitEntity(TraitImport trait);
}
