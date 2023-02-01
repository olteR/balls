package olter.balls.database.importer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

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
    private List<String> boosts;
    private List<String> flaws;
    private List<String> languages;
    private List<String> traits;
    private ArrayList<String> flavor;
    public ArrayList<Object> info;
    private ArrayList<String> heritageInfo;
    private ArrayList<HeritageImport> heritage;
    private List<Feature> features;
    private Summary summary;
}

class Feature {
    public String name;
    public ArrayList<String> entries;
}

class Summary {
    public String text;
    public ArrayList<String> images;
}
