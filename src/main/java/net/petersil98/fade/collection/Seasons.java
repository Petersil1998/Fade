package net.petersil98.fade.collection;

import net.petersil98.fade.data.Season;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Seasons {

    private static Map<String, Season> seasons;

    public static Season getSeason(String id) {
        return seasons.get(id);
    }

    public static List<Season> getSeasons() {
        return new ArrayList<>(seasons.values());
    }
}
