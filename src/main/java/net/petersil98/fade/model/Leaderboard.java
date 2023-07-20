package net.petersil98.fade.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(using = Deserializers.LeaderboardDeserializer.class)
public class Leaderboard {

    private final List<RankEntry> players;
    private final int totalPlayers;
    private final int immortalStartingPage;
    private final int immortalStartingIndex;
    private final int topTierRRThreshold;

    public Leaderboard(List<RankEntry> players, int totalPlayers, int immortalStartingPage, int immortalStartingIndex, int topTierRRThreshold) {
        this.players = players;
        this.totalPlayers = totalPlayers;
        this.immortalStartingPage = immortalStartingPage;
        this.immortalStartingIndex = immortalStartingIndex;
        this.topTierRRThreshold = topTierRRThreshold;
    }

    public List<RankEntry> getPlayers() {
        return players;
    }

    public int getTotalPlayers() {
        return totalPlayers;
    }

    public int getImmortalStartingPage() {
        return immortalStartingPage;
    }

    public int getImmortalStartingIndex() {
        return immortalStartingIndex;
    }

    public int getTopTierRRThreshold() {
        return topTierRRThreshold;
    }
}
