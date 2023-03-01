package olter.balls.database.core.enums;

public enum ActivityUnitEnum {
  FREE("free"),
  ACTION("action"),
  REACTION("reaction"),
  MINUTE("minute"),
  HOUR("hour"),
  DAY("day"),
  WEEK("week"),
  MONTH("month"),
  YEAR("year");

  private final String value;

  ActivityUnitEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
