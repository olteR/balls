package olter.balls.database.importer;

import java.util.List;

public class ImporterUtils {
  public <T> String toHtmlParagraphs(List<T> list, boolean filterStrings) {
    return "<p>"
        .concat(
            filterStrings
                ? String.join(
                    "</p><p>",
                    list.stream()
                        .filter(e -> e.getClass() == String.class)
                        .map(Object::toString)
                        .toList())
                : String.join("</p><p>", list.stream().map(Object::toString).toList()))
        .concat("</p>");
  }
}
