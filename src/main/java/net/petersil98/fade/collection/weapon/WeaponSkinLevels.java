package net.petersil98.fade.collection.weapon;

import net.petersil98.fade.data.weapon.WeaponSkinLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WeaponSkinLevels {

    private static Map<String, WeaponSkinLevel> weaponSkinLevels;

    public static WeaponSkinLevel getWeaponSkinLevel(String id) {
        return weaponSkinLevels.get(id);
    }

    public static List<WeaponSkinLevel> getWeaponSkinLevels() {
        return new ArrayList<>(weaponSkinLevels.values());
    }
}
