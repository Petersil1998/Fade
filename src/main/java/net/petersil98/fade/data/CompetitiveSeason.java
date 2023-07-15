package net.petersil98.fade.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.petersil98.fade.model.Deserializers;

import java.util.List;
import java.util.Objects;

@JsonDeserialize(using = Deserializers.CompetitiveSeasonDeserializer.class)
public class CompetitiveSeason {

    private final String id;
    private final long startTime;
    private final long endTime;
    private final Season season;
    private final CompetitiveTier competitiveTier;
    private final List<Border> borders;

    public CompetitiveSeason(String id, long startTime, long endTime, Season season, CompetitiveTier competitiveTier, List<Border> borders) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.season = season;
        this.competitiveTier = competitiveTier;
        this.borders = borders;
    }

    public String getId() {
        return id;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public Season getSeason() {
        return season;
    }

    public CompetitiveTier getCompetitiveTier() {
        return competitiveTier;
    }

    public List<Border> getBorders() {
        return borders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompetitiveSeason that = (CompetitiveSeason) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Border {

        @JsonProperty("uuid")
        private String id;
        private int level;
        private int winsRequired;
        private String displayIcon;
        private String smallIcon;

        public String getId() {
            return id;
        }

        public int getLevel() {
            return level;
        }

        public int getWinsRequired() {
            return winsRequired;
        }

        public String getDisplayIcon() {
            return displayIcon;
        }

        public String getSmallIcon() {
            return smallIcon;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Border border = (Border) o;
            return Objects.equals(id, border.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}
