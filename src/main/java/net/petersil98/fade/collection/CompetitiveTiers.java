package net.petersil98.fade.collection;

import net.petersil98.fade.data.CompetitiveTier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CompetitiveTiers {

    private static Map<String, CompetitiveTier> competitiveTiers;

    public static CompetitiveTier getCompetitiveTier(String id) {
        return competitiveTiers.get(id);
    }

    public static List<CompetitiveTier> getCompetitiveTiers() {
        return new ArrayList<>(competitiveTiers.values());
    }
}
