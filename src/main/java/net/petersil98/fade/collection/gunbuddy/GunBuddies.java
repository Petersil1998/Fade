package net.petersil98.fade.collection.gunbuddy;

import net.petersil98.fade.data.gunbuddy.GunBuddy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GunBuddies {

    private static Map<String, GunBuddy> gunBuddies;

    public static GunBuddy getGunBuddy(String id) {
        return gunBuddies.get(id);
    }

    public static List<GunBuddy> getGunBuddies() {
        return new ArrayList<>(gunBuddies.values());
    }
}
