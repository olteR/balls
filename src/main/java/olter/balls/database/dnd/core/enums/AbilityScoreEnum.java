package olter.balls.database.dnd.core.enums;

public enum AbilityScoreEnum {
    STR("strength"),
    DEX("dexterity"),
    CON("constitution"),
    INT("intelligence"),
    WIS("wisdom"),
    CHA("charisma");

    private final String value;

    private AbilityScoreEnum(String value) {
        this.value = value;
    }

    private String getValue() {
        return this.value;
    }
}
