package olter.balls.database.languages;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.ancestries.AncestryEntity;
import olter.balls.database.core.SourcedEntity;
import olter.balls.database.core.enums.LanguageTypeEnum;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "languages")
public class LanguageEntity extends SourcedEntity {
    @Column(unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    private LanguageTypeEnum type;

    @ManyToMany(mappedBy = "knownLanguages", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<AncestryEntity> ancestriesKnowing;

    @ManyToMany(mappedBy = "additionalLanguages", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<AncestryEntity> ancestriesAsAdditional;
}
