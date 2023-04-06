package olter.balls.database.importer.dto.spell;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.importer.dto.ValueWithUnitImport;

@Getter
@Setter
@RequiredArgsConstructor
public class SpellImport {
  private String name;
  private String source;
  private Long page;
  private Long level;
  private boolean focus;
  private String trigger;
  private String targets;
  private String requirements;
  private List<String> traits;
  private List<String> traditions;
  private ValueWithUnitImport cast;
  private ValueWithUnitImport range;
  private List<List<String>> components;
  private AreaImport area;
  private SavingThrowImport savingThrow;
  private DurationImport duration;

  // delet

  private Object subclass;
  private Object heightened;
  private List<Object> entries;
  private List<String> miscTags;
  private List<String> domains;
  private Object amp;
}
