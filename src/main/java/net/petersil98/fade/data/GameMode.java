package net.petersil98.fade.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameMode {

    @JsonProperty("uuid")
    private String id;
    @JsonProperty("displayName")
    private String name;
    private String duration;
    @JsonProperty("allowsMatchTimeouts")
    private boolean allowsMatchTimeouts;
    @JsonProperty("isTeamVoiceAllowed")
    private boolean isTeamVoiceAllowed;
    @JsonProperty("isMinimapHidden")
    private boolean isMinimapHidden;
    private int orbCount;
    private int roundsPerHalf;
    private String displayIcon;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }

    public boolean allowsMatchTimeouts() {
        return allowsMatchTimeouts;
    }

    public boolean isTeamVoiceAllowed() {
        return isTeamVoiceAllowed;
    }

    public boolean isMinimapHidden() {
        return isMinimapHidden;
    }

    public int getOrbCount() {
        return orbCount;
    }

    public int getRoundsPerHalf() {
        return roundsPerHalf;
    }

    public String getDisplayIcon() {
        return displayIcon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameMode gameMode = (GameMode) o;
        return Objects.equals(id, gameMode.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
