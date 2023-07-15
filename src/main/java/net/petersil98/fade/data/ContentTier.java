package net.petersil98.fade.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.petersil98.fade.model.Deserializers;

import java.awt.*;
import java.util.Objects;

@JsonDeserialize(using = Deserializers.ContentTierDeserializer.class)
public class ContentTier {

    private final String id;
    private final String name;
    private final int rank;
    private final int juiceValue;
    private final int juiceCost;
    private final Color highlightColor;
    private final String displayIcon;

    public ContentTier(String id, String name, int rank, int juiceValue, int juiceCost, Color highlightColor, String displayIcon) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.juiceValue = juiceValue;
        this.juiceCost = juiceCost;
        this.highlightColor = highlightColor;
        this.displayIcon = displayIcon;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    public int getJuiceValue() {
        return juiceValue;
    }

    public int getJuiceCost() {
        return juiceCost;
    }

    public Color getHighlightColor() {
        return highlightColor;
    }


    public String getDisplayIcon() {
        return displayIcon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContentTier contentTier = (ContentTier) o;
        return Objects.equals(id, contentTier.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
