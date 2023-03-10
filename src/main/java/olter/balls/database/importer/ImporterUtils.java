package olter.balls.database.importer;

import java.util.List;
import java.util.Objects;
import olter.balls.database.core.embeddables.ActivityEmbeddable;
import olter.balls.database.core.enums.ActivityUnitEnum;
import olter.balls.database.importer.dto.ActivityImport;

public class ImporterUtils {

  public static <T> String toHtmlParagraphs(List<T> list, boolean filterStrings) {
    return wrapParagraph(
        filterStrings
            ? String.join(
                "</p><p>",
                list.stream()
                    .filter(e -> e.getClass() == String.class)
                    .map(Object::toString)
                    .toList())
            : String.join("</p><p>", list.stream().map(Object::toString).toList()));
  }

  public static ActivityEmbeddable mapActivity(ActivityImport activity) {
    if (activity != null) {
      ActivityEmbeddable embeddable = new ActivityEmbeddable();
      if (!Objects.equals(activity.getUnit(), "varies")) {
        embeddable.setMinCast(activity.getNumber());
        embeddable.setMaxCast(activity.getNumber());
        embeddable.setMinCastUnits(ActivityUnitEnum.valueOf(activity.getUnit().toUpperCase()));
        embeddable.setMaxCastUnits(ActivityUnitEnum.valueOf(activity.getUnit().toUpperCase()));
      } else if (activity.getEntry().contains("{@as") && activity.getEntry().contains("to")) {
        String[] castTimes = activity.getEntry().split("to", 2);
        embeddable.setMinCast(getLongFromString(castTimes[0], null));
        embeddable.setMaxCast(getLongFromString(castTimes[1], null));
        embeddable.setMinCastUnits(
            castTimes[0].contains("{@as")
                ? ActivityUnitEnum.ACTION
                : ActivityUnitEnum.valueOf(getLettersFromString(castTimes[0].toUpperCase())));
        embeddable.setMinCastUnits(
            castTimes[1].contains("{@as")
                ? ActivityUnitEnum.ACTION
                : ActivityUnitEnum.valueOf(getLettersFromString(castTimes[1].toUpperCase())));
      } else {
        embeddable.setSpecial(activity.getEntry());
      }
      return embeddable;
    }
    return null;
  }

  public static String wrapParagraph(String p) {
    return "<p>".concat(p).concat("</p>");
  }

  public static Long getLongFromString(String s, Long def) {
    String replaced = s.replaceAll("[^0-9]", "");
    return Objects.equals(replaced, "") ? def : Long.valueOf(replaced);
  }

  public static String getLettersFromString(String s) {
    return s.replaceAll("[^a-zA-Z]", "");
  }
}
