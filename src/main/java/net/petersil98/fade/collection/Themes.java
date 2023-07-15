package net.petersil98.fade.collection;

import net.petersil98.fade.data.Theme;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Themes {

    private static Map<String, Theme> themes;

    public static Theme getTheme(String id) {
        return themes.get(id);
    }

    public static List<Theme> getThemes() {
        return new ArrayList<>(themes.values());
    }
}
