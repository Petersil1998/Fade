package net.petersil98.fade.collection.spray;

import net.petersil98.fade.data.spray.Spray;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Sprays {

    private static Map<String, Spray> sprays;

    public static Spray getSpray(String id) {
        return sprays.get(id);
    }

    public static List<Spray> getSprays() {
        return new ArrayList<>(sprays.values());
    }
}
