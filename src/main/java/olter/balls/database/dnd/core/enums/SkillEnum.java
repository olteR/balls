package olter.balls.database.dnd.core.enums;

public enum SkillEnum {
    ACROBATICS("acrobatics"),
    ANIMAL_HANDLING("animal_handling"),
    ARCANA("arcana"),
    ATHLETICS("athletics"),
    DECEPTION("deception"),
    HISTORY("history"),
    INSIGHT("insight"),
    INTIMIDATION("intimidation"),
    INVESTIGATION("investigation"),
    MEDICINE("medicine"),
    NATURE("nature"),
    PERCEPTION("perception"),
    PERFORMANCE("performance"),
    PERSUASION("persuasion"),
    RELIGION("religion"),
    SLEIGHT_OF_HAND("sleight_of_hand"),
    STEALTH("stealth"),
    SURVIVAL("survival");

    private final String value;

    private SkillEnum(String value) {
        this.value = value;
    }

    private String getValue() {
        return this.value;
    }

    private AbilityScoreEnum getAbilityScore() {
        return switch (this) {
            case ATHLETICS -> AbilityScoreEnum.STR;
            case ACROBATICS, SLEIGHT_OF_HAND, STEALTH -> AbilityScoreEnum.DEX;
            case ARCANA, HISTORY, INVESTIGATION, NATURE, RELIGION -> AbilityScoreEnum.INT;
            case ANIMAL_HANDLING, INSIGHT, MEDICINE, PERCEPTION, SURVIVAL -> AbilityScoreEnum.WIS;
            case DECEPTION, INTIMIDATION, PERFORMANCE, PERSUASION -> AbilityScoreEnum.CHA;
        };
    }
}
