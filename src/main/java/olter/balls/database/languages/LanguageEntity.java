package olter.balls.database.languages;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.ancestries.AncestryEntity;
import olter.balls.database.core.SourcedEntity;

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
}
