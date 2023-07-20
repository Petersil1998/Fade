package net.petersil98.fade.model.match;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.type.TypeFactory;
import net.petersil98.fade.constants.QueueType;
import net.petersil98.fade.constants.ValRegion;
import net.petersil98.fade.data.GameMode;
import net.petersil98.fade.data.Map;
import net.petersil98.fade.data.Season;
import net.petersil98.fade.http.ValAPI;
import net.petersil98.fade.model.Deserializers;

import java.util.List;
import java.util.stream.StreamSupport;

@JsonDeserialize(using = Deserializers.MatchDetailsDeserializer.class)
public class MatchDetails {

    private final Map map;
    private final long gameLengthMillis;
    private final long gameStartMillis;
    private final String provisioningFlowId;
    private final boolean isCompleted;
    private final String customGameName;
    private final QueueType queue;
    private final GameMode gameMode;
    private final boolean isRanked;
    private final Season season;
    private final List<Player> players;
    private final List<Coach> coaches;
    private final List<Team> teams;
    private final List<RoundResult> roundResults;

    public MatchDetails(Map map, long gameLengthMillis, long gameStartMillis, String provisioningFlowId, boolean isCompleted, String customGameName, QueueType queue, GameMode gameMode, boolean isRanked, Season season, List<Player> players, List<Coach> coaches, List<Team> teams, List<RoundResult> roundResults) {
        this.map = map;
        this.gameLengthMillis = gameLengthMillis;
        this.gameStartMillis = gameStartMillis;
        this.provisioningFlowId = provisioningFlowId;
        this.isCompleted = isCompleted;
        this.customGameName = customGameName;
        this.queue = queue;
        this.gameMode = gameMode;
        this.isRanked = isRanked;
        this.season = season;
        this.players = players;
        this.coaches = coaches;
        this.teams = teams;
        this.roundResults = roundResults;
    }

    public static MatchDetails getMatchDetails(String matchId, ValRegion region) {
        return ValAPI.requestValMatchEndpoint("matches/", matchId, region, MatchDetails.class);
    }

    public static List<MatchDetails> getMatchHistory(String puuid, ValRegion region) {
        java.util.Map<String, JsonNode> response = ValAPI.requestValMatchEndpoint("matches/by-puuid/", puuid, region, TypeFactory.defaultInstance().constructMapType(java.util.Map.class, String.class, JsonNode.class));
        List<String> matchIds = StreamSupport.stream(response.get("history").spliterator(), false)
                .map(node -> node.get("matchId").asText()).toList();
        return matchIds.stream().map(matchId -> MatchDetails.getMatchDetails(matchId, region)).toList();
    }

    public static List<MatchDetails> getRecentMatches(QueueType queue, ValRegion region) {
        java.util.Map<String, JsonNode> response = ValAPI.requestValMatchEndpoint("recent-matches/by-queue/", queue.getJsonPropertyValue(), region, TypeFactory.defaultInstance().constructMapType(java.util.Map.class, String.class, JsonNode.class));
        List<String> matchIds = StreamSupport.stream(response.get("matchIds").spliterator(), false)
                .map(JsonNode::asText).toList();
        return matchIds.stream().map(matchId -> MatchDetails.getMatchDetails(matchId, region)).toList();
    }

    public Map getMap() {
        return map;
    }

    public long getGameLengthMillis() {
        return gameLengthMillis;
    }

    public long getGameStartMillis() {
        return gameStartMillis;
    }

    public String getProvisioningFlowId() {
        return provisioningFlowId;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String getCustomGameName() {
        return customGameName;
    }

    public QueueType getQueue() {
        return queue;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public boolean isRanked() {
        return isRanked;
    }

    public Season getSeason() {
        return season;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }
}
