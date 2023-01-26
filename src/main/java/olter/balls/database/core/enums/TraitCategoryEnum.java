package olter.balls.database.core.enums;

public enum TraitCategoryEnum {
    ABILITY("ability"),
    ACTION("action"),
    ALIGNMENT("alignment"),
    ANCESTRY("ancestry"),
    ARMOR("armor"),
    CLASS("class"),
    COMBAT("combat"),
    CREATURE_TYPE("creature_type"),
    EFFECT("effect"),
    ELEMENT("element"),
    ENERGY("energy"),
    EQUIPMENT("equipment"),
    FEAT("feat"),
    GENERAL("general"),
    GRAVITY("gravity"),
    HAZARD("hazard"),
    ITEM("item"),
    MONSTER("monster"),
    MORPHIC("morphic"),
    PLANAR("planar"),
    POISON("poison"),
    RARITY("rarity"),
    SCHOOL("school"),
    SCOPE("scope"),
    SENSE("sense"),
    SETTLEMENT("settlement"),
    SPELL("spell"),
    TIME("time"),
    TRADITION("tradition"),
    WEAPON("weapon");

    private final String value;

    private TraitCategoryEnum(String value) {
        this.value = value;
    }

    private String getValue() {
        return this.value;
    }
}
