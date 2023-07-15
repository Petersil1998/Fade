package net.petersil98.fade.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.petersil98.fade.model.Deserializers;

import java.awt.*;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompetitiveTier {

    @JsonProperty("uuid")
    private String id;
    private List<Tier> tiers;

    public String getId() {
        return id;
    }

    public List<Tier> getTiers() {
        return tiers;
    }

    @JsonDeserialize(using = Deserializers.TierDeserializer.class)
    public static class Tier {

        private final int id;
        private final String name;
        private final String division;
        private final Color color;
        private final Color backgroundColor;
        private final String smallIcon;
        private final String largeIcon;
        private final String rankTriangleDownIcon;
        private final String rankTriangleUpIcon;

        public Tier(int id, String name, String division, Color color, Color backgroundColor, String smallIcon, String largeIcon, String rankTriangleDownIcon, String rankTriangleUpIcon) {
            this.id = id;
            this.name = name;
            this.division = division;
            this.color = color;
            this.backgroundColor = backgroundColor;
            this.smallIcon = smallIcon;
            this.largeIcon = largeIcon;
            this.rankTriangleDownIcon = rankTriangleDownIcon;
            this.rankTriangleUpIcon = rankTriangleUpIcon;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDivision() {
            return division;
        }

        public Color getColor() {
            return color;
        }

        public Color getBackgroundColor() {
            return backgroundColor;
        }

        public String getSmallIcon() {
            return smallIcon;
        }

        public String getLargeIcon() {
            return largeIcon;
        }

        public String getRankTriangleDownIcon() {
            return rankTriangleDownIcon;
        }

        public String getRankTriangleUpIcon() {
            return rankTriangleUpIcon;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompetitiveTier that = (CompetitiveTier) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
