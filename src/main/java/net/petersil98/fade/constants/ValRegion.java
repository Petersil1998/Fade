package net.petersil98.fade.constants;

import net.petersil98.core.constant.Region;

public class ValRegion extends Region {
    public static final ValRegion AP = new ValRegion("ap");
    public static final ValRegion BR = new ValRegion("br");
    public static final ValRegion E_SPORTS = new ValRegion("esports");
    public static final ValRegion EU = new ValRegion("eu");
    public static final ValRegion KR = new ValRegion("kr");
    public static final ValRegion LATAM = new ValRegion("latam");
    public static final ValRegion NA = new ValRegion("na");

    protected ValRegion(String name) {
        super(name);
    }
}
