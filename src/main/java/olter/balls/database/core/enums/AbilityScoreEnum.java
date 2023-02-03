package olter.balls.database.core.enums;

public enum AbilityScoreEnum {
    STR("strength"),
    DEX("dexterity"),
    CON("constitution"),
    INT("intelligence"),
    WIS("wisdom"),
    CHA("charisma");

    private final String value;

    AbilityScoreEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
