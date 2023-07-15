package net.petersil98.fade.collection.weapon;

import net.petersil98.fade.data.weapon.WeaponSkinChroma;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WeaponSkinChromas {

    private static Map<String, WeaponSkinChroma> weaponSkinChromas;

    public static WeaponSkinChroma getWeaponSkinChroma(String id) {
        return weaponSkinChromas.get(id);
    }

    public static List<WeaponSkinChroma> getWeaponSkinChromas() {
        return new ArrayList<>(weaponSkinChromas.values());
    }
}
