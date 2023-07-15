package net.petersil98.fade.collection.gunbuddy;

import net.petersil98.fade.data.gunbuddy.GunBuddyLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GunBuddyLevels {

    private static Map<String, GunBuddyLevel> gunBuddyLevels;

    public static GunBuddyLevel getGunBuddyLevel(String id) {
        return gunBuddyLevels.get(id);
    }

    public static List<GunBuddyLevel> getGunBuddyLevels() {
        return new ArrayList<>(gunBuddyLevels.values());
    }
}
