package net.petersil98.fade.data.spray;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SprayLevel {

    @JsonProperty("uuid")
    private String id;
    @JsonProperty("displayName")
    private String name;
    private int sprayLevel;
    private String displayIcon;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSprayLevel() {
        return sprayLevel;
    }

    public String getDisplayIcon() {
        return displayIcon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SprayLevel that = (SprayLevel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
