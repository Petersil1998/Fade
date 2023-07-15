package net.petersil98.fade.collection;

import net.petersil98.fade.data.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bundles {

    private static Map<String, Bundle> bundles;

    public static Bundle getBundle(String id) {
        return bundles.get(id);
    }

    public static List<Bundle> getBundles() {
        return new ArrayList<>(bundles.values());
    }
}
