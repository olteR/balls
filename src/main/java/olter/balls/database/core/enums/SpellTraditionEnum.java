package olter.balls.database.core.enums;

public enum SpellTraditionEnum {
  ARCANE("arcane"),
  DIVINE("divine"),
  OCCULT("occult"),
  PRIMAL("primal");

  private final String value;

  SpellTraditionEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
