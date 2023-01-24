package olter.balls.database.core.enums;

public enum AbilityChangeEnum {
    STR("strength"),
    DEX("dexterity"),
    CON("constitution"),
    INT("intelligence"),
    WIS("wisdom"),
    CHA("charisma"),
    FREE("free");

    private final String value;

    private AbilityChangeEnum(String value) {
        this.value = value;
    }

    private String getValue() {
        return this.value;
    }
}
