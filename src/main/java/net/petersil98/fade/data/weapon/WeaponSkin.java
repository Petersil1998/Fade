package net.petersil98.fade.data.weapon;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.petersil98.fade.collection.weapon.WeaponSkinChromas;
import net.petersil98.fade.data.ContentTier;
import net.petersil98.fade.data.Theme;
import net.petersil98.fade.model.Deserializers;

import java.util.List;
import java.util.Objects;

@JsonDeserialize(using = Deserializers.WeaponSkinDeserializer.class)
public class WeaponSkin {

    private final String id;
    private final String name;
    private final Theme theme;
    private final ContentTier contentTier;
    private final String displayIcon;
    private final String wallpaper;
    private final List<WeaponSkinChroma> chromas;
    private final List<WeaponSkinLevel> levels;

    public WeaponSkin(String id, String name, Theme theme, ContentTier contentTier, String displayIcon, String wallpaper, List<WeaponSkinChroma> chromas, List<WeaponSkinLevel> levels) {
        this.id = id;
        this.name = name;
        this.theme = theme;
        this.contentTier = contentTier;
        this.displayIcon = displayIcon;
        this.wallpaper = wallpaper;
        this.chromas = chromas;
        this.levels = levels;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Theme getTheme() {
        return theme;
    }

    public ContentTier getContentTier() {
        return contentTier;
    }

    public String getDisplayIcon() {
        return displayIcon;
    }

    public String getWallpaper() {
        return wallpaper;
    }

    public List<WeaponSkinChroma> getChromas() {
        return chromas;
    }

    public List<WeaponSkinLevel> getLevels() {
        return levels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeaponSkin that = (WeaponSkin) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
