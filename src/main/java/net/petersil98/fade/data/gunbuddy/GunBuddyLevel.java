package net.petersil98.fade.data.gunbuddy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GunBuddyLevel {

    @JsonProperty("uuid")
    private String id;
    private int charmLevel;
    @JsonProperty("displayName")
    private String name;
    private String displayIcon;

    public String getId() {
        return id;
    }

    public int getCharmLevel() {
        return charmLevel;
    }

    public String getName() {
        return name;
    }

    public String getDisplayIcon() {
        return displayIcon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GunBuddyLevel gunBuddyLevel = (GunBuddyLevel) o;
        return Objects.equals(id, gunBuddyLevel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
