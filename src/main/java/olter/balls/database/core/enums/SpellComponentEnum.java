package olter.balls.database.core.enums;

public enum SpellComponentEnum {
    SOMATIC("somatic"),
    VERBAL("verbal"),
    MATERIAL("material");

    private final String value;

    SpellComponentEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
