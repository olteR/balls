package olter.balls.database.dnd.core.enums;

public enum CurrencyTypeEnum {
    COPPER("copper"),
    SILVER("silver"),
    ELECTRUM("electrum"),
    GOLD("gold"),
    PLATINUM("platinum");

    private final String value;

    private CurrencyTypeEnum(String value) {
        this.value = value;
    }

    private String getValue() {
        return this.value;
    }
}
