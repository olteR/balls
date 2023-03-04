package olter.balls.database.core.enums;

public enum FrequencyUnitEnum {
  ROUND("round"),
  MINUTE("minute"),
  HOUR("hour"),
  DAY("day"),
  WEEK("week"),
  MONTH("month"),
  YEAR("year");

  private final String value;

  FrequencyUnitEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
