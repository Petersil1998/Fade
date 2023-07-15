package net.petersil98.fade.collection.weapon;

import net.petersil98.fade.data.weapon.WeaponSkin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WeaponSkins {

    private static Map<String, WeaponSkin> weaponSkins;

    public static WeaponSkin getWeaponSkin(String id) {
        return weaponSkins.get(id);
    }

    public static List<WeaponSkin> getWeaponSkins() {
        return new ArrayList<>(weaponSkins.values());
    }
}
