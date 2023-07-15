package net.petersil98.fade.data.gunbuddy;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.petersil98.fade.data.Theme;
import net.petersil98.fade.model.Deserializers;

import java.util.List;
import java.util.Objects;

@JsonDeserialize(using = Deserializers.GunBuddyDeserializer.class)
public class GunBuddy {

    private final String id;
    private final String name;
    private final boolean isHiddenIfNotOwned;
    private final Theme theme;
    private final String displayIcon;
    private final List<GunBuddyLevel> levels;

    public GunBuddy(String id, String name, boolean isHiddenIfNotOwned, Theme theme, String displayIcon, List<GunBuddyLevel> levels) {
        this.id = id;
        this.name = name;
        this.isHiddenIfNotOwned = isHiddenIfNotOwned;
        this.theme = theme;
        this.displayIcon = displayIcon;
        this.levels = levels;
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

    public List<GunBuddyLevel> getLevels() {
        return levels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GunBuddy gunBuddy = (GunBuddy) o;
        return Objects.equals(id, gunBuddy.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
