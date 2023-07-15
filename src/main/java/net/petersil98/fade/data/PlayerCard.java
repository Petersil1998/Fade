package net.petersil98.fade.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.petersil98.fade.model.Deserializers;

import java.util.Objects;

@JsonDeserialize(using = Deserializers.PlayerCardDeserializer.class)
public class PlayerCard {

    private final String id;
    private final String name;
    private final boolean isHiddenIfNotOwned;
    private final Theme theme;
    private final String displayIcon;
    private final String smallArt;
    private final String wideArt;
    private final String largeArt;

    public PlayerCard(String id, String name, boolean isHiddenIfNotOwned, Theme theme, String displayIcon, String smallArt, String wideArt, String largeArt) {
        this.id = id;
        this.name = name;
        this.isHiddenIfNotOwned = isHiddenIfNotOwned;
        this.theme = theme;
        this.displayIcon = displayIcon;
        this.smallArt = smallArt;
        this.wideArt = wideArt;
        this.largeArt = largeArt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isHiddenIfNotOwned() {
        return isHiddenIfNotOwned;
    }

    public Theme getTheme() {
        return theme;
    }

    public String getDisplayIcon() {
        return displayIcon;
    }

    public String getSmallArt() {
        return smallArt;
    }

    public String getWideArt() {
        return wideArt;
    }

    public String getLargeArt() {
        return largeArt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerCard that = (PlayerCard) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
