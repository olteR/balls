package olter.balls.database.dnd.core.enums;

public enum SizeEnum {
    TINY("tiny"),
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large"),
    HUGE("huge"),
    GARGANTUAN("gargantuan");

    private final String value;

    private SizeEnum(String value) {
        this.value = value;
    }

    private String getValue() {
        return this.value;
    }
}
