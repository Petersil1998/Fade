package net.petersil98.fade.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerTitle {

    @JsonProperty("uuid")
    private String id;
    @JsonProperty("titleText")
    private String title;
    private boolean isHiddenIfNotOwned;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isHiddenIfNotOwned() {
        return isHiddenIfNotOwned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerTitle that = (PlayerTitle) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
