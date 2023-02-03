package olter.balls.database.importer.dto.ancestry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.importer.dto.HeritageImport;
import olter.balls.database.importer.dto.ancestry.AncestryFeatureImport;
import olter.balls.database.importer.dto.ancestry.AncestrySpeedImport;
import olter.balls.database.importer.dto.ancestry.AncestrySummaryImport;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AncestryImport {
    private String name;
    private String source;
    private Integer page;
    private String rarity;
    private Integer hp;
    @JsonProperty("size")
    private List<String> sizes;
    private AncestrySpeedImport speed;
    private List<String> boosts;
    private List<String> flaw;
    private List<String> languages;
    private List<String> traits;
    private ArrayList<String> flavor;
    private ArrayList<Object> info;
    private ArrayList<String> heritageInfo;
    private ArrayList<HeritageImport> heritage;
    private List<AncestryFeatureImport> features;
    private AncestrySummaryImport summary;
}