package olter.balls.database.ancestries;

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
