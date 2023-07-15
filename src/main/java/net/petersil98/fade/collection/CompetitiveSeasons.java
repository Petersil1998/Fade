package net.petersil98.fade.collection;

import net.petersil98.fade.data.CompetitiveSeason;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CompetitiveSeasons {

    private static Map<String, CompetitiveSeason> competitiveSeasons;

    public static CompetitiveSeason getCompetitiveSeason(String id) {
        return competitiveSeasons.get(id);
    }

    public static List<CompetitiveSeason> getCompetitiveSeasons() {
        return new ArrayList<>(competitiveSeasons.values());
    }
}
