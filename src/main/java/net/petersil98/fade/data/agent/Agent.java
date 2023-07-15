package net.petersil98.fade.data.agent;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.petersil98.fade.model.Deserializers;

import java.awt.*;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(using = Deserializers.AgentDeserializer.class)
public class Agent {

    private final String id;
    private final String name;
    private final String description;
    private final List<String> characterTags;
    private final String displayIcon;
    private final String displayIconSmall;
    private final String bustPortrait;
    private final String fullPortrait;
    private final String fullPortraitV2;
    private final String killfeedPortrait;
    private final String background;
    private final List<Color> backgroundGradientColors;
    private final boolean isFullPortraitRightFacing;
    private final boolean isBaseContent;
    private final Role role;
    private final List<Ability> abilities;
    private final VoiceLine voiceLine;

    public Agent(String id, String name, String description, List<String> characterTags, String displayIcon, String displayIconSmall, String bustPortrait, String fullPortrait, String fullPortraitV2, String killfeedPortrait, String background, List<Color> backgroundGradientColors, boolean isFullPortraitRightFacing, boolean isBaseContent, Role role, List<Ability> abilities, VoiceLine voiceLine) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.characterTags = characterTags;
        this.displayIcon = displayIcon;
        this.displayIconSmall = displayIconSmall;
        this.bustPortrait = bustPortrait;
        this.fullPortrait = fullPortrait;
        this.fullPortraitV2 = fullPortraitV2;
        this.killfeedPortrait = killfeedPortrait;
        this.background = background;
        this.backgroundGradientColors = backgroundGradientColors;
        this.isFullPortraitRightFacing = isFullPortraitRightFacing;
        this.isBaseContent = isBaseContent;
        this.role = role;
        this.abilities = abilities;
        this.voiceLine = voiceLine;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getCharacterTags() {
        return characterTags;
    }

    public String getDisplayIcon() {
        return displayIcon;
    }

    public String getDisplayIconSmall() {
        return displayIconSmall;
    }

    public String getBustPortrait() {
        return bustPortrait;
    }

    public String getFullPortrait() {
        return fullPortrait;
    }

    public String getFullPortraitV2() {
        return fullPortraitV2;
    }

    public String getKillfeedPortrait() {
        return killfeedPortrait;
    }

    public String getBackground() {
        return background;
    }

    public List<Color> getBackgroundGradientColors() {
        return backgroundGradientColors;
    }

    public boolean isFullPortraitRightFacing() {
        return isFullPortraitRightFacing;
    }

    public boolean isBaseContent() {
        return isBaseContent;
    }

    public Role getRole() {
        return role;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public VoiceLine getVoiceLine() {
        return voiceLine;
    }

    public static class Ability {
        private Slot slot;
        @JsonProperty("displayName")
        private String name;
        private String description;
        private String displayIcon;

        public Slot getSlot() {
            return slot;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getDisplayIcon() {
            return displayIcon;
        }
    }

    public enum Slot {
        @JsonProperty("Ability1")
        ABILITY_1,
        @JsonProperty("Ability2")
        ABILITY_2,
        @JsonProperty("Grenade")
        GRENADE,
        @JsonProperty("Ultimate")
        ULTIMATE,
        @JsonProperty("Passive")
        PASSIVE
    }

    public static class VoiceLine {
        private long minDuration;
        private long maxDuration;
        private List<Media> mediaList;

        public long getMinDuration() {
            return minDuration;
        }

        public long getMaxDuration() {
            return maxDuration;
        }

        public List<Media> getMediaList() {
            return mediaList;
        }
    }

    public static class Media {
        private long id;
        private String wwise;
        private String wave;

        public long getId() {
            return id;
        }

        public String getWwise() {
            return wwise;
        }

        public String getWave() {
            return wave;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agent agent = (Agent) o;
        return Objects.equals(id, agent.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
