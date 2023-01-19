package olter.balls.database.dnd.items;

import olter.balls.database.dnd.core.embeddables.TimeEmbeddable;
import olter.balls.database.dnd.core.enums.TimeUnitEnum;

public enum ArmorTypeEnum {
    LIGHT_ARMOR("light_armor"),
    MEDIUM_ARMOR("medium_armor"),
    HEAVY_ARMOR("heavy_armor"),
    SHIELD("shield");

    private final String value;

    private ArmorTypeEnum(String value) {
        this.value = value;
    }

    private String getValue() {
        return this.value;
    }

    private TimeEmbeddable getDonTime() {
        return switch (this) {
            case LIGHT_ARMOR -> new TimeEmbeddable(1, TimeUnitEnum.MINUTE);
            case MEDIUM_ARMOR -> new TimeEmbeddable(5, TimeUnitEnum.MINUTE);
            case HEAVY_ARMOR -> new TimeEmbeddable(10, TimeUnitEnum.MINUTE);
            case SHIELD -> new TimeEmbeddable(1, TimeUnitEnum.ACTION);
        };
    }

    private TimeEmbeddable getDoffTime() {
        return switch (this) {
            case LIGHT_ARMOR, MEDIUM_ARMOR -> new TimeEmbeddable(1, TimeUnitEnum.MINUTE);
            case HEAVY_ARMOR -> new TimeEmbeddable(5, TimeUnitEnum.MINUTE);
            case SHIELD -> new TimeEmbeddable(1, TimeUnitEnum.ACTION);
        };
    }
}
