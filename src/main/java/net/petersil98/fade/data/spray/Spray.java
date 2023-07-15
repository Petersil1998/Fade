package net.petersil98.fade.data.spray;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.petersil98.fade.data.Theme;
import net.petersil98.fade.model.Deserializers;

import java.util.List;
import java.util.Objects;

@JsonDeserialize(using = Deserializers.SprayDeserializer.class)
public class Spray {

    private final String id;
    private final String name;
    private final Theme theme;
    private final boolean isNullSpray;
    private final String displayIcon;
    private final String fullIcon;
    private final String fullTransparentIcon;
    private final String animationPng;
    private final String animationGif;
    private final List<SprayLevel> levels;

    public Spray(String id, String name, Theme theme, boolean isNullSpray, String displayIcon, String fullIcon, String fullTransparentIcon, String animationPng, String animationGif, List<SprayLevel> levels) {
        this.id = id;
        this.name = name;
        this.theme = theme;
        this.isNullSpray = isNullSpray;
        this.displayIcon = displayIcon;
        this.fullIcon = fullIcon;
        this.fullTransparentIcon = fullTransparentIcon;
        this.animationPng = animationPng;
        this.animationGif = animationGif;
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

    public boolean isNullSpray() {
        return isNullSpray;
    }

    public String getDisplayIcon() {
        return displayIcon;
    }

    public String getFullIcon() {
        return fullIcon;
    }

    public String getFullTransparentIcon() {
        return fullTransparentIcon;
    }

    public String getAnimationPng() {
        return animationPng;
    }

    public String getAnimationGif() {
        return animationGif;
    }

    public List<SprayLevel> getLevels() {
        return levels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spray spray = (Spray) o;
        return Objects.equals(id, spray.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
