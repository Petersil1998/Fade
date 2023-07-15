package net.petersil98.fade.data.weapon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopData {
    private int cost;
    @JsonProperty("category")
    private GearCategory gearCategory;
    private boolean canBeTrashed;
    private String image;
    private String newImage;
    private String newImage2;

    public int getCost() {
        return cost;
    }

    public GearCategory getGearCategory() {
        return gearCategory;
    }

    public boolean isCanBeTrashed() {
        return canBeTrashed;
    }

    public String getImage() {
        return image;
    }

    public String getNewImage() {
        return newImage;
    }

    public String getNewImage2() {
        return newImage2;
    }
}