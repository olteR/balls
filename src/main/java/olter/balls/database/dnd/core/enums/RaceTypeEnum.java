package olter.balls.database.dnd.core.enums;

public enum RaceTypeEnum {
    COMMON("common"),
    CUSTOM("custom"),
    EXOTIC("exotic"),
    MONSTROUS("monstrous"),
    SETTING_SPECIFIC("setting_specific");

    private final String value;

    private RaceTypeEnum(String value) {
        this.value = value;
    }

    private String getValue() {
        return this.value;
    }
}
