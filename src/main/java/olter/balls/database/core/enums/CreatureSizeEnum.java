package olter.balls.database.core.enums;

public enum CreatureSizeEnum {
	TINY("tiny"),
	SMALL("small"),
	MEDIUM("medium"),
	LARGE("large"),
	HUGE("huge"),
	GARGANTUAN("gargantuan");

	private final String value;

	CreatureSizeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
