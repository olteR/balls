package olter.balls.database.core.enums;

public enum CreatureSizeEnum {
    TINY("tiny"),
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large"),
    HUGE("huge"),
    GARGANTUAN("gargantuan");

    private final String value;

    private CreatureSizeEnum(String value) {
        this.value = value;
    }

    private String getValue() {
        return this.value;
    }
}
