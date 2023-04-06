package olter.balls.database.core.enums;

public enum AreaTypeEnum {
  BURST("burst"),
  CONE("cone"),
  EMANATION("emanation"),
  LINE("line"),
  MISC("misc");

  private final String value;

  AreaTypeEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
