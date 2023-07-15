package net.petersil98.fade.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bundle {

    @JsonProperty("uuid")
    private String id;
    @JsonProperty("displayName")
    private String name;
    @JsonProperty("extraDescription")
    private String description;
    private String promoDescription;
    private String displayIcon;
    private String displayIcon2;
    private String verticalPromoImage;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPromoDescription() {
        return promoDescription;
    }

    public String getDisplayIcon() {
        return displayIcon;
    }

    public String getDisplayIcon2() {
        return displayIcon2;
    }

    public String getVerticalPromoImage() {
        return verticalPromoImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bundle bundle = (Bundle) o;
        return Objects.equals(id, bundle.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
