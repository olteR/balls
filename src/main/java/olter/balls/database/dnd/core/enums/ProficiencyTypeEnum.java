package olter.balls.database.dnd.core.enums;

public enum ProficiencyTypeEnum {
    WEAPON("weapon"),
    ARMOR("armor"),
    SKILL("skill"),
    TECH("tech"),
    LANGUAGE("language");

    private final String value;

    private ProficiencyTypeEnum(String value) {
        this.value = value;
    }

    private String getValue() {
        return this.value;
    }
}
