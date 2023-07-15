package net.petersil98.fade.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ceremony {

    @JsonProperty("uuid")
    private String id;
    @JsonProperty("displayName")
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ceremony ceremony = (Ceremony) o;
        return Objects.equals(id, ceremony.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
