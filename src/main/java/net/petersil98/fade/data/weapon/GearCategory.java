package net.petersil98.fade.data.weapon;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum GearCategory {
    @JsonProperty("Armor")
    ARMOR("Shields"),
    @JsonProperty("Pistols")
    PISTOLS("Sidearms"),
    @JsonProperty("Heavy Weapons")
    HEAVY_WEAPONS("Heavy Weapons"),
    @JsonProperty("Rifles")
    RIFLES("Assault Rifles"),
    @JsonProperty("Shotguns")
    SHOTGUNS("Shotguns"),
    @JsonProperty("Sniper Rifles")
    SNIPER_RIFLES("Sniper Rifles"),
    @JsonProperty("SMGs")
    SMGS("SMGs");

    private final String name;
    GearCategory(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
