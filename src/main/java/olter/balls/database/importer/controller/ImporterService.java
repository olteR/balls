package olter.balls.database.importer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.database.actions.controller.ActionService;
import olter.balls.database.ancestries.ancestry.controller.AncestryService;
import olter.balls.database.importer.dto.SourceImport;
import olter.balls.database.importer.dto.action.ActionImport;
import olter.balls.database.sources.controller.SourceService;
import olter.balls.database.importer.dto.ImportResponse;
import olter.balls.database.importer.dto.LanguageImport;
import olter.balls.database.importer.dto.TraitImport;
import olter.balls.database.importer.dto.ancestry.AncestryImport;
import olter.balls.database.importer.dto.ancestry.AncestryImportResponse;
import olter.balls.database.languages.controller.LanguageService;
import olter.balls.database.traits.controller.TraitService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImporterService {

  @Value("${import.url}")
  private String IMPORT_URL;

  private final ActionService actionService;
  private final AncestryService ancestryService;
  private final SourceService sourceService;
  private final LanguageService languageService;
  private final TraitService traitService;

  public ImportResponse importAbilities() throws JsonProcessingException {
    return new ImportResponse();
  }

  public ImportResponse importActions() throws JsonProcessingException {
    return actionService.processImports(fetchData("actions.json", ActionImport[].class));
  }

  public AncestryImportResponse importAncestries() throws JsonProcessingException {
    RestTemplate restTemplate = new RestTemplate();

    ResponseEntity<String> responseJson =
        restTemplate.exchange(
            IMPORT_URL.concat("ancestries/index.json"),
            HttpMethod.GET,
            generateHttpEntity(),
            String.class);
    String[] sources = Objects.requireNonNull(responseJson.getBody()).split(",");
    List<AncestryImport> imports = new ArrayList<>();
    for (String source : sources) {
      source = source.substring(source.indexOf(':') + 3, source.lastIndexOf('"'));
      if (!source.equals("versatile-heritages.json")) {
        imports.add(fetchData("ancestries/".concat(source), AncestryImport.class));
      }
    }
    return ancestryService.processImports(imports);
  }

  public ImportResponse importBackgrounds() throws JsonProcessingException {
    return new ImportResponse();
  }

  public ImportResponse importClasses() throws JsonProcessingException {
    return new ImportResponse();
  }

  public ImportResponse importFeats() throws JsonProcessingException {
    return new ImportResponse();
  }

  public ImportResponse importItems() throws JsonProcessingException {
    return new ImportResponse();
  }

  public ImportResponse importSpells() throws JsonProcessingException {
    return new ImportResponse();
  }

  public ImportResponse importLanguages() throws JsonProcessingException {
    return languageService.processImports(fetchData("languages.json", LanguageImport[].class));
  }

  public ImportResponse importSources() throws JsonProcessingException {
    return sourceService.processImports(fetchData("sources.json", SourceImport[].class));
  }

  public ImportResponse importTraits() throws JsonProcessingException {
    return traitService.processImports(fetchData("traits.json", TraitImport[].class));
  }

  private HttpEntity<String> generateHttpEntity() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("user-agent", "Application");
    headers.setAccept(List.of(MediaType.APPLICATION_JSON));
    headers.setContentType(MediaType.APPLICATION_JSON);
    return new HttpEntity<>(headers);
  }

  private <T> T fetchData(String url, Class<T> type) throws JsonProcessingException {
    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper mapper = new ObjectMapper();

    ResponseEntity<String> responseJson =
        restTemplate.exchange(
            IMPORT_URL.concat(url), HttpMethod.GET, generateHttpEntity(), String.class);
    return mapper.readValue(
        Objects.requireNonNull(responseJson.getBody())
            .substring(
                responseJson.getBody().indexOf('[') + (type.isArray() ? 0 : 1),
                responseJson.getBody().lastIndexOf(']') + (type.isArray() ? 1 : 0)),
        type);
  }
}
