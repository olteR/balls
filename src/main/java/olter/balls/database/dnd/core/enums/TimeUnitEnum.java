package olter.balls.database.dnd.core.enums;

public enum TimeUnitEnum {
    ACTION("action"),
    BONUS_ACTION("bonus_action"),
    MINUTE("minute"),
    HOUR("hour"),
    DAY("day");

    private final String value;

    private TimeUnitEnum(String value) {
        this.value = value;
    }

    private String getValue() {
        return this.value;
    }
}
