package net.petersil98.fade.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Maps {

    private static Map<String, net.petersil98.fade.data.Map> maps;

    public static net.petersil98.fade.data.Map getMap(String id) {
        return maps.get(id);
    }

    public static List<net.petersil98.fade.data.Map> getMaps() {
        return new ArrayList<>(maps.values());
    }
}
