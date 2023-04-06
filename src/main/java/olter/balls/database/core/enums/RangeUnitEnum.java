package olter.balls.database.core.enums;

public enum RangeUnitEnum {
  TOUCH("touch"),
  FEET("feet"),
  MILE("mile"),
  PLANETARY("planetary");

  private final String value;

  RangeUnitEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
