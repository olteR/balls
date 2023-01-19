package olter.balls.database.dnd.core.embeddables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class CharacterSheetEmbeddable {
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charisma;
    private Integer inspiration;
    private Integer proficiencyBonus;
    private boolean strSavingThrow;
    private boolean dexSavingThrow;
    private boolean conSavingThrow;
    private boolean intSavingThrow;
    private boolean wisSavingThrow;
    private boolean chaSavingThrow;
    private boolean acrobatics;
    private boolean animalHandling;
    private boolean arcana;
    private boolean athletics;
    private boolean deception;
    private boolean history;
    private boolean insight;
    private boolean intimidation;
    private boolean investigation;
    private boolean medicine;
    private boolean nature;
    private boolean perception;
    private boolean performance;
    private boolean persuasion;
    private boolean religion;
    private boolean sleightOfHand;
    private boolean stealth;
    private boolean survival;
    @Column(columnDefinition="TEXT")
    private String personalityTraits;
    @Column(columnDefinition="TEXT")
    private String ideals;
    @Column(columnDefinition="TEXT")
    private String bonds;
    @Column(columnDefinition="TEXT")
    private String flaws;
    private Integer cp;
    private Integer sp;
    private Integer ep;
    private Integer gp;
    private Integer pp;
    private Integer age;
    private String height;
    private String weight;
    private String eyes;
    private String skin;
    private String hair;
    @Column(columnDefinition="TEXT")
    private String characterAppearance;
    @Column(columnDefinition="TEXT")
    private String characterBackstory;
    @Column(columnDefinition="TEXT")
    private String alliesAndOrganizations;
    @Column(columnDefinition="TEXT")
    private String additionalFeaturesAndTraits;
    @Column(columnDefinition="TEXT")
    private String treasure;
}
