package net.petersil98.fade.collection;

import net.petersil98.fade.data.Ceremony;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ceremonies {

    private static Map<String, Ceremony> ceremonies;

    public static Ceremony getCeremony(String id) {
        return ceremonies.get(id);
    }

    public static List<Ceremony> getCeremonies() {
        return new ArrayList<>(ceremonies.values());
    }
}
