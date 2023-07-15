package net.petersil98.fade.data.weapon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeaponSkinChroma {

    @JsonProperty("uuid")
    private String id;
    @JsonProperty("displayName")
    private String name;
    private String displayIcon;
    private String fullRender;
    private String swatch;
    private String streamedVideo;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDisplayIcon() {
        return displayIcon;
    }

    public String getFullRender() {
        return fullRender;
    }

    public String getSwatch() {
        return swatch;
    }

    public String getStreamedVideo() {
        return streamedVideo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeaponSkinChroma that = (WeaponSkinChroma) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
