package net.petersil98.fade.data.weapon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Shield {

    @JsonProperty("uuid")
    private String id;
    @JsonProperty("displayName")
    private String name;
    private String description;
    private String displayIcon;
    private ShopData shopData;

    public String getId() {
        return id;
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

    public ShopData getShopData() {
        return shopData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shield shield = (Shield) o;
        return Objects.equals(id, shield.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
