package net.petersil98.fade.data.weapon;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.petersil98.fade.model.Deserializers;

import java.util.List;
import java.util.Objects;

@JsonDeserialize(using = Deserializers.WeaponDeserializer.class)
public class Weapon {

    private final String id;
    private final String name;
    private final WeaponSkin defaultSkin;
    private final String displayIcon;
    private final String killStreamIcon;
    private final Stats stats;
    private final ShopData shopData;
    private final List<WeaponSkin> skins;

    public Weapon(String id, String name, WeaponSkin defaultSkin, String displayIcon, String killStreamIcon, Stats stats, ShopData shopData, List<WeaponSkin> skins) {
        this.id = id;
        this.name = name;
        this.defaultSkin = defaultSkin;
        this.displayIcon = displayIcon;
        this.killStreamIcon = killStreamIcon;
        this.stats = stats;
        this.shopData = shopData;
        this.skins = skins;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public WeaponSkin getDefaultSkin() {
        return defaultSkin;
    }

    public String getDisplayIcon() {
        return displayIcon;
    }

    public String getKillStreamIcon() {
        return killStreamIcon;
    }

    public Stats getStats() {
        return stats;
    }

    public ShopData getShopData() {
        return shopData;
    }

    public List<WeaponSkin> getSkins() {
        return skins;
    }

    public static class Stats {

        private float fireRate;
        private int magazineSize;
        private float runSpeedMultiplier;
        private float equipTimeSeconds;
        private float reloadTimeSeconds;
        private float firstBulletAccuracy;
        private int shotgunPelletCount;
        private Penetration wallPenetration;
        private Feature feature;
        private FireMode fireMode;
        private FireType altFireType;
        @JsonProperty("adsStats")
        private AddedStats addedStats;
        private ShotgunStats altShotgunStats;
        private AirBurstStats airBurstStats;
        private List<DamageRange> damageRanges;

        public float getFireRate() {
            return fireRate;
        }

        public int getMagazineSize() {
            return magazineSize;
        }

        public float getRunSpeedMultiplier() {
            return runSpeedMultiplier;
        }

        public float getEquipTimeSeconds() {
            return equipTimeSeconds;
        }

        public float getReloadTimeSeconds() {
            return reloadTimeSeconds;
        }

        public float getFirstBulletAccuracy() {
            return firstBulletAccuracy;
        }

        public int getShotgunPelletCount() {
            return shotgunPelletCount;
        }

        public Penetration getWallPenetration() {
            return wallPenetration;
        }

        public Feature getFeature() {
            return feature;
        }

        public FireMode getFireMode() {
            return fireMode;
        }

        public FireType getAltFireType() {
            return altFireType;
        }

        public AddedStats getAddedStats() {
            return addedStats;
        }

        public ShotgunStats getAltShotgunStats() {
            return altShotgunStats;
        }

        public AirBurstStats getAirBurstStats() {
            return airBurstStats;
        }

        public List<DamageRange> getDamageRanges() {
            return damageRanges;
        }
    }

    public enum Penetration {
        @JsonProperty("EWallPenetrationDisplayType::Low")
        LOW,
        @JsonProperty("EWallPenetrationDisplayType::Medium")
        MEDIUM,
        @JsonProperty("EWallPenetrationDisplayType::High")
        HIGH
    }

    public enum Feature {
        @JsonProperty("EWeaponStatsFeature::ROFIncrease")
        ROF_INCREASED,
        @JsonProperty("EWeaponStatsFeature::Silenced")
        SILENCED,
        @JsonProperty("EWeaponStatsFeature::DualZoom")
        DUAL_ZOOM
    }

    public enum FireMode {
        @JsonProperty("EWeaponFireModeDisplayType::SemiAutomatic")
        SEMI_AUTOMATIC
    }

    public enum FireType {
        @JsonProperty("EWeaponAltFireDisplayType::ADS")
        ADS,
        @JsonProperty("EWeaponAltFireDisplayType::AirBurst")
        AIR_BURST,
        @JsonProperty("EWeaponAltFireDisplayType::Shotgun")
        SHOTGUN
    }

    public static class AddedStats {
        private float zoomMultiplier;
        private float fireRate;
        private float runSpeedMultiplier;
        private float burstCount;
        private float firstBulletAccuracy;

        public float getZoomMultiplier() {
            return zoomMultiplier;
        }

        public float getFireRate() {
            return fireRate;
        }

        public float getRunSpeedMultiplier() {
            return runSpeedMultiplier;
        }

        public float getBurstCount() {
            return burstCount;
        }

        public float getFirstBulletAccuracy() {
            return firstBulletAccuracy;
        }
    }

    public static class ShotgunStats {
        private int shotgunPelletCount;
        private float burstRate;

        public int getShotgunPelletCount() {
            return shotgunPelletCount;
        }

        public float getBurstRate() {
            return burstRate;
        }
    }

    public static class AirBurstStats {
        private int shotgunPelletCount;
        private float burstDistance;

        public int getShotgunPelletCount() {
            return shotgunPelletCount;
        }

        public float getBurstDistance() {
            return burstDistance;
        }
    }

    public static class DamageRange {
        private int rangeStartMeters;
        private int rangeEndMeters;
        private int headDamage;
        private int bodyDamage;
        private int legDamage;

        public int getRangeStartMeters() {
            return rangeStartMeters;
        }

        public int getRangeEndMeters() {
            return rangeEndMeters;
        }

        public int getHeadDamage() {
            return headDamage;
        }

        public int getBodyDamage() {
            return bodyDamage;
        }

        public int getLegDamage() {
            return legDamage;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return Objects.equals(id, weapon.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
