package olter.balls.database.core.enums;

public enum LanguageTypeEnum {
    COMMON("common"),
    UNCOMMON("uncommon"),
    RARE("rare"),
    SECRET("secret"),
    REGIONAL("regional");

    private final String value;

    private LanguageTypeEnum(String value) {
        this.value = value;
    }

    private String getValue() {
        return this.value;
    }
}
