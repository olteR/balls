package olter.balls.database.core.enums;

public enum AncestryRarityEnum {
    COMMON("common"),
    UNCOMMON("uncommon"),
    RARE("rare");

    private final String value;

    private AncestryRarityEnum(String value) {
        this.value = value;
    }

    private String getValue() {
        return this.value;
    }
}
