package net.petersil98.fade.collection;

import net.petersil98.fade.data.LevelBorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LevelBorders {

    private static Map<String, LevelBorder> levelBorders;

    public static LevelBorder getLevelBorder(String id) {
        return levelBorders.get(id);
    }

    public static List<LevelBorder> getLevelBorders() {
        return new ArrayList<>(levelBorders.values());
    }
}
