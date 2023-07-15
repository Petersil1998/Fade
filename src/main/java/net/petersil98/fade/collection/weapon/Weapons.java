package net.petersil98.fade.collection.weapon;

import net.petersil98.fade.data.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Weapons {

    private static Map<String, Weapon> weapons;

    public static Weapon getWeapon(String id) {
        return weapons.get(id);
    }

    public static List<Weapon> getWeapons() {
        return new ArrayList<>(weapons.values());
    }
}
