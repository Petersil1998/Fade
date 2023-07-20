package net.petersil98.fade.model.match;

import net.petersil98.fade.data.CompetitiveTier;
import net.petersil98.fade.data.PlayerCard;
import net.petersil98.fade.data.PlayerTitle;
import net.petersil98.fade.data.agent.Agent;

import java.util.Map;

public class Player {

    private final String puuid;
    private final String name;
    private final String tag;
    private final Team team;
    private final int partyId;
    private final Agent agent;
    private final Stats stats;
    private final CompetitiveTier competitiveTier;
    private final PlayerCard playerCard;
    private final PlayerTitle playerTitle;

    public Player(String puuid, String name, String tag, Team team, int partyId, Agent agent, Stats stats, CompetitiveTier competitiveTier, PlayerCard playerCard, PlayerTitle playerTitle) {
        this.puuid = puuid;
        this.name = name;
        this.tag = tag;
        this.team = team;
        this.partyId = partyId;
        this.agent = agent;
        this.stats = stats;
        this.competitiveTier = competitiveTier;
        this.playerCard = playerCard;
        this.playerTitle = playerTitle;
    }

    public String getPuuid() {
        return puuid;
    }

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public Team getTeam() {
        return team;
    }

    public int getPartyId() {
        return partyId;
    }

    public Agent getAgent() {
        return agent;
    }

    public Stats getStats() {
        return stats;
    }

    public CompetitiveTier getCompetitiveTier() {
        return competitiveTier;
    }

    public PlayerCard getPlayerCard() {
        return playerCard;
    }

    public PlayerTitle getPlayerTitle() {
        return playerTitle;
    }

    public static class Stats {

        private final int score;
        private final int roundsPlayed;
        private final int kills;
        private final int deaths;
        private final int assists;
        private final int playtimeMillis;
        private final java.util.Map<Agent.Slot, Integer> abilityCasts;

        public Stats(int score, int roundsPlayed, int kills, int deaths, int assists, int playtimeMillis, Map<Agent.Slot, Integer> abilityCasts) {
            this.score = score;
            this.roundsPlayed = roundsPlayed;
            this.kills = kills;
            this.deaths = deaths;
            this.assists = assists;
            this.playtimeMillis = playtimeMillis;
            this.abilityCasts = abilityCasts;
        }

        public int getScore() {
            return score;
        }

        public int getRoundsPlayed() {
            return roundsPlayed;
        }

        public int getKills() {
            return kills;
        }

        public int getDeaths() {
            return deaths;
        }

        public int getAssists() {
            return assists;
        }

        public int getPlaytimeMillis() {
            return playtimeMillis;
        }

        public Map<Agent.Slot, Integer> getAbilityCasts() {
            return abilityCasts;
        }
    }
}
