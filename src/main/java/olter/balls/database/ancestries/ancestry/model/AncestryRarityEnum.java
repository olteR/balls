package olter.balls.database.ancestries.ancestry.model;

public enum AncestryRarityEnum {
  COMMON("common"),
  UNCOMMON("uncommon"),
  RARE("rare");

  private final String value;

  AncestryRarityEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
