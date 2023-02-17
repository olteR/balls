package olter.balls.database.languages;

public enum LanguageTypeEnum {
	COMMON("common"),
	UNCOMMON("uncommon"),
	RARE("rare"),
	SECRET("secret"),
	REGIONAL("regional");

	private final String value;

	LanguageTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
