package net.petersil98.fade.collection.spray;

import net.petersil98.fade.data.spray.SprayLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SprayLevels {

    private static Map<String, SprayLevel> sprayLevels;

    public static SprayLevel getSprayLevel(String id) {
        return sprayLevels.get(id);
    }

    public static List<SprayLevel> getSprayLevels() {
        return new ArrayList<>(sprayLevels.values());
    }
}
