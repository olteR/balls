export function formatEnum(e) {
  return e.replace("_", " ").toLowerCase();
}

export function formatAbilityScore(as) {
  if (as) {
    switch (as.toUpperCase()) {
      case "STR":
        return "strength";
      case "DEX":
        return "dexterity";
      case "CON":
        return "constitution";
      case "INT":
        return "intelligence";
      case "WIS":
        return "wisdom";
      case "CHA":
        return "charisma";
    }
  }
  return "free";
}
