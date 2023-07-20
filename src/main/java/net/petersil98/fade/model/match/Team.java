package net.petersil98.fade.model.match;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Team {

    @JsonProperty("teamId")
    private String id;
    @JsonProperty("won")
    private boolean won;
    private int roundsPlayed;
    private int roundsWon;
    private int numPoints;

    public String getId() {
        return id;
    }

    public boolean hasWon() {
        return won;
    }

    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    public int getRoundsWon() {
        return roundsWon;
    }

    public int getNumPoints() {
        return numPoints;
    }
}
