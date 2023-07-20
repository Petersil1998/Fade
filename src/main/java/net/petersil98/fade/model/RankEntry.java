package net.petersil98.fade.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RankEntry {

    private String puuid;
    @JsonProperty("gameName")
    private String name;
    @JsonProperty("tagLine")
    private String tag;

    private int leaderboardRank;
    private int rankedRating;
    private int numberOfWins;
    private int competitiveTier;

    public String getPuuid() {
        return puuid;
    }

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public int getLeaderboardRank() {
        return leaderboardRank;
    }

    public int getRankedRating() {
        return rankedRating;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public int getCompetitiveTier() {
        return competitiveTier;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s#%s %d LP %d wins", leaderboardRank, name, tag, rankedRating, numberOfWins);
    }
}
