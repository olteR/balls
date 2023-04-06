package olter.balls.database.core.enums;

public enum SavingThrowTypeEnum {
    FORTITUDE("fortitude"),
    REFLEX("reflex"),
    WILL("will");

    private final String value;

    SavingThrowTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
