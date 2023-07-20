package net.petersil98.fade.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.petersil98.fade.util.Point;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Map {

    @JsonProperty("uuid")
    private String id;
    @JsonProperty("displayName")
    private String name;
    private String coordinates;
    private String displayIcon;
    private String listViewIcon;
    private String splash;
    private float xMultiplier;
    private float yMultiplier;
    private float xScalarToAdd;
    private float yScalarToAdd;
    private List<Callout> callouts;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public String getDisplayIcon() {
        return displayIcon;
    }

    public String getListViewIcon() {
        return listViewIcon;
    }

    public String getSplash() {
        return splash;
    }

    public float getxMultiplier() {
        return xMultiplier;
    }

    public float getyMultiplier() {
        return yMultiplier;
    }

    public float getxScalarToAdd() {
        return xScalarToAdd;
    }

    public float getyScalarToAdd() {
        return yScalarToAdd;
    }

    public List<Callout> getCallouts() {
        return callouts;
    }

    public static class Callout {
        private String regionName;
        private String superRegionName;
        private Point location;

        public String getRegionName() {
            return regionName;
        }

        public String getSuperRegionName() {
            return superRegionName;
        }

        public Point getLocation() {
            return location;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Map map = (Map) o;
        return Objects.equals(id, map.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
