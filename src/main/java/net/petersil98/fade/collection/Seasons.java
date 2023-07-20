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

    public static Season getSeasonByName(String name) {
        return getSeasons().stream().filter(season -> season.getName().equals(name)).findAny().orElse(null);
    }

    public static Season getEpisode(int episode) {
        return getSeasons().stream().filter(season -> season.getName().equals("EPISODE " + episode)).findAny().orElse(null);
    }

    public static Season getEpisodeAct(int episode, int act) {
        List<Season> seasonList = getSeasons();
        Season ep = getEpisode(episode);
        return seasonList.stream().filter(season -> season.getName().equals("ACT " + act) && season.getParent().equals(ep)).findAny().orElse(null);
    }

    public static List<Season> getSeasons() {
        return new ArrayList<>(seasons.values());
    }

}
