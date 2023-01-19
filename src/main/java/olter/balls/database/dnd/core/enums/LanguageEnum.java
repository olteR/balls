package olter.balls.database.dnd.core.enums;

import olter.balls.database.dnd.core.embeddables.TimeEmbeddable;

public enum LanguageEnum {
    ABYSSAL("abyssal"),
    CELESTIAL("celestial"),
    COMMON("common"),
    DEEP_SPEECH("deep_speech"),
    DRACONIC("draconic"),
    DRUIDIC("druidic"),
    DWARVISH("dwarvish"),
    ELVISH("elvish"),
    GIANT("giant"),
    GNOMISH("gnomish"),
    GOBLIN("goblin"),
    HALFLING("halfling"),
    INFERNAL("infernal"),
    ORC("orc"),
    PRIMORDIAL("primordial"),
    SYLVAN("sylvan"),
    THIEVES_CANT("thieves_cant"),
    UNDERCOMMON("undercommon");

    private final String value;

    private LanguageEnum(String value) {
        this.value = value;
    }

    private String getValue() {
        return this.value;
    }

    private String getType() {
        return switch (this) {
            case ABYSSAL, CELESTIAL, DEEP_SPEECH, DRACONIC, INFERNAL, PRIMORDIAL, SYLVAN, UNDERCOMMON -> "exotic";
            case DRUIDIC, THIEVES_CANT -> "secret";
            case COMMON, DWARVISH, ELVISH, GIANT, GNOMISH, GOBLIN, HALFLING, ORC -> "standard";
        };
    }

    private String getScript() {
        return switch (this) {
            case CELESTIAL -> "celestial";
            case COMMON, HALFLING -> "common";
            case DRACONIC -> "draconic";
            case DWARVISH, GIANT, GNOMISH, GOBLIN, ORC, PRIMORDIAL -> "dwarvish";
            case ELVISH, SYLVAN, UNDERCOMMON -> "elvish";
            case ABYSSAL, INFERNAL -> "infernal";
            case DRUIDIC, DEEP_SPEECH, THIEVES_CANT -> "none";
        };
    }
}
