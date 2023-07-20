package net.petersil98.fade.model;

import net.petersil98.fade.constants.ValRegion;
import net.petersil98.fade.http.ValAPI;
import net.petersil98.fade.util.Util;

import java.util.Map;

public class ValRanked {

    public static Leaderboard getLeaderboard(ValRegion region, String actId) {
        return getLeaderboard(region, actId, Map.of());
    }

    public static Leaderboard getLeaderboard(ValRegion region, String actId, Map<String, String> filter) {
        Util.validateFilter(filter);
        return ValAPI.requestValRankedEndpoint("leaderboards/by-act/", actId, region, Leaderboard.class, filter);
    }
}
