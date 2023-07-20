package net.petersil98.fade.model.match;

public class Coach {

    private final String puuid;
    private final Team team;

    public Coach(String puuid, Team team) {
        this.puuid = puuid;
        this.team = team;
    }

    public String getPuuid() {
        return puuid;
    }

    public Team getTeam() {
        return team;
    }
}
