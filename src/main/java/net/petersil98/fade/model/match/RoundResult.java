package net.petersil98.fade.model.match;

import net.petersil98.fade.data.agent.Agent;
import net.petersil98.fade.data.weapon.Shield;
import net.petersil98.fade.data.weapon.Weapon;
import net.petersil98.fade.util.Point;

import java.util.List;
import java.util.Map;

public class RoundResult {

    private final int roundNum;
    private final String roundResult;
    // TODO Cemeronies?
    private final String roundCeremony;
    private final Team winningTeam;
    private final Player bombPlanter;
    private final Player bombDefuser;
    private final int plantRoundTime;
    private final List<PlayerLocation> plantPlayerLocations;
    private final Point plantLocation;
    private final String plantSite;
    private final int defuseRoundTime;
    private final List<PlayerLocation> defusePlayerLocations;
    private final Point defuseLocation;
    private final Map<Player, PlayerRoundStats> playerStats;
    private final String roundResultCode;

    public RoundResult(int roundNum, String roundResult, String roundCeremony, Team winningTeam, Player bombPlanter, Player bombDefuser, int plantRoundTime, List<PlayerLocation> plantPlayerLocations, Point plantLocation, String plantSite, int defuseRoundTime, List<PlayerLocation> defusePlayerLocations, Point defuseLocation, Map<Player, PlayerRoundStats> playerStats, String roundResultCode) {
        this.roundNum = roundNum;
        this.roundResult = roundResult;
        this.roundCeremony = roundCeremony;
        this.winningTeam = winningTeam;
        this.bombPlanter = bombPlanter;
        this.bombDefuser = bombDefuser;
        this.plantRoundTime = plantRoundTime;
        this.plantPlayerLocations = plantPlayerLocations;
        this.plantLocation = plantLocation;
        this.plantSite = plantSite;
        this.defuseRoundTime = defuseRoundTime;
        this.defusePlayerLocations = defusePlayerLocations;
        this.defuseLocation = defuseLocation;
        this.playerStats = playerStats;
        this.roundResultCode = roundResultCode;
    }

    public int getRoundNum() {
        return roundNum;
    }

    public String getRoundResult() {
        return roundResult;
    }

    public String getRoundCeremony() {
        return roundCeremony;
    }

    public Team getWinningTeam() {
        return winningTeam;
    }

    public Player getBombPlanter() {
        return bombPlanter;
    }

    public Player getBombDefuser() {
        return bombDefuser;
    }

    public int getPlantRoundTime() {
        return plantRoundTime;
    }

    public List<PlayerLocation> getPlantPlayerLocations() {
        return plantPlayerLocations;
    }

    public Point getPlantLocation() {
        return plantLocation;
    }

    public String getPlantSite() {
        return plantSite;
    }

    public int getDefuseRoundTime() {
        return defuseRoundTime;
    }

    public List<PlayerLocation> getDefusePlayerLocations() {
        return defusePlayerLocations;
    }

    public Point getDefuseLocation() {
        return defuseLocation;
    }

    public Map<Player, PlayerRoundStats> getPlayerStats() {
        return playerStats;
    }

    public String getRoundResultCode() {
        return roundResultCode;
    }

    public static class PlayerLocation {

        private final Player player;
        private final float viewRadians;
        private final Point location;

        public PlayerLocation(Player player, float viewRadians, Point location) {
            this.player = player;
            this.viewRadians = viewRadians;
            this.location = location;
        }

        public Player getPlayer() {
            return player;
        }

        public float getViewRadians() {
            return viewRadians;
        }

        public Point getLocation() {
            return location;
        }
    }

    public static class PlayerRoundStats {

        private final Player player;
        private final List<Kill> kills;
        private final List<Damage> damage;
        private final int score;
        private final Economy economy;
        private final Map<Agent.Slot, String> abilityEffects;

        public PlayerRoundStats(Player player, List<Kill> kills, List<Damage> damage, int score, Economy economy, Map<Agent.Slot, String> abilityEffects) {
            this.player = player;
            this.kills = kills;
            this.damage = damage;
            this.score = score;
            this.economy = economy;
            this.abilityEffects = abilityEffects;
        }

        public Player getPlayer() {
            return player;
        }

        public List<Kill> getKills() {
            return kills;
        }

        public List<Damage> getDamage() {
            return damage;
        }

        public int getScore() {
            return score;
        }

        public Economy getEconomy() {
            return economy;
        }

        public Map<Agent.Slot, String> getAbilityEffects() {
            return abilityEffects;
        }
    }

    public static class Kill {

        private final int timeSinceGameStartMillis;
        private final int timeSinceRoundStartMillis;
        private final Player killer;
        private final Player victim;
        private final Point victimLocation;
        private final List<Player> assistants;
        private final List<PlayerLocation> playerLocations;
        private final FinishingDamage finishingDamage;

        public Kill(int timeSinceGameStartMillis, int timeSinceRoundStartMillis, Player killer, Player victim, Point victimLocation, List<Player> assistants, List<PlayerLocation> playerLocations, FinishingDamage finishingDamage) {
            this.timeSinceGameStartMillis = timeSinceGameStartMillis;
            this.timeSinceRoundStartMillis = timeSinceRoundStartMillis;
            this.killer = killer;
            this.victim = victim;
            this.victimLocation = victimLocation;
            this.assistants = assistants;
            this.playerLocations = playerLocations;
            this.finishingDamage = finishingDamage;
        }

        public int getTimeSinceGameStartMillis() {
            return timeSinceGameStartMillis;
        }

        public int getTimeSinceRoundStartMillis() {
            return timeSinceRoundStartMillis;
        }

        public Player getKiller() {
            return killer;
        }

        public Player getVictim() {
            return victim;
        }

        public Point getVictimLocation() {
            return victimLocation;
        }

        public List<Player> getAssistants() {
            return assistants;
        }

        public List<PlayerLocation> getPlayerLocations() {
            return playerLocations;
        }

        public FinishingDamage getFinishingDamage() {
            return finishingDamage;
        }
    }

    public static class Damage {

        private final Player receiver;
        private final int damage;
        private final int legshots;
        private final int bodyshots;
        private final int headshots;

        public Damage(Player receiver, int damage, int legshots, int bodyshots, int headshots) {
            this.receiver = receiver;
            this.damage = damage;
            this.legshots = legshots;
            this.bodyshots = bodyshots;
            this.headshots = headshots;
        }

        public Player getReceiver() {
            return receiver;
        }

        public int getDamage() {
            return damage;
        }

        public int getLegshots() {
            return legshots;
        }

        public int getBodyshots() {
            return bodyshots;
        }

        public int getHeadshots() {
            return headshots;
        }
    }

    public static class Economy {

        private final int loadoutValue;
        private final Weapon weapon;
        private final Shield armor;
        private final int remaining;
        private final int spent;

        public Economy(int loadoutValue, Weapon weapon, Shield armor, int remaining, int spent) {
            this.loadoutValue = loadoutValue;
            this.weapon = weapon;
            this.armor = armor;
            this.remaining = remaining;
            this.spent = spent;
        }

        public int getLoadoutValue() {
            return loadoutValue;
        }

        public Weapon getWeapon() {
            return weapon;
        }

        public Shield getArmor() {
            return armor;
        }

        public int getRemaining() {
            return remaining;
        }

        public int getSpent() {
            return spent;
        }
    }

    public static class FinishingDamage {

        private String damageType;
        private String damageItem;
        private boolean isSecondaryFireMode;

        public String getDamageType() {
            return damageType;
        }

        public String getDamageItem() {
            return damageItem;
        }

        public boolean isSecondaryFireMode() {
            return isSecondaryFireMode;
        }
    }
}
