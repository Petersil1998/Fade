package net.petersil98.fade.collection.weapon;

import net.petersil98.fade.data.weapon.Shield;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Shields {

    private static Map<String, Shield> shields;

    public static Shield getShield(String id) {
        return shields.get(id);
    }

    public static List<Shield> getShields() {
        return new ArrayList<>(shields.values());
    }
}
