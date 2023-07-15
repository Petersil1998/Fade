package net.petersil98.fade.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LevelBorder {

    @JsonProperty("uuid")
    private String id;
    private int startingLevel;
    private String levelNumberAppearance;
    private String smallPlayerCardAppearance;

    public String getId() {
        return id;
    }

    public int getStartingLevel() {
        return startingLevel;
    }

    public String getLevelNumberAppearance() {
        return levelNumberAppearance;
    }

    public String getSmallPlayerCardAppearance() {
        return smallPlayerCardAppearance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LevelBorder levelBorder = (LevelBorder) o;
        return Objects.equals(id, levelBorder.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
