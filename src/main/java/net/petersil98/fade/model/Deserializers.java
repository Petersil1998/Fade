package net.petersil98.fade.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.petersil98.fade.collection.*;
import net.petersil98.fade.collection.agent.Agents;
import net.petersil98.fade.collection.gunbuddy.GunBuddyLevels;
import net.petersil98.fade.collection.spray.SprayLevels;
import net.petersil98.fade.collection.spray.Sprays;
import net.petersil98.fade.collection.weapon.WeaponSkinChromas;
import net.petersil98.fade.collection.weapon.WeaponSkinLevels;
import net.petersil98.fade.collection.weapon.WeaponSkins;
import net.petersil98.fade.data.Event;
import net.petersil98.fade.data.*;
import net.petersil98.fade.data.agent.Agent;
import net.petersil98.fade.data.agent.Role;
import net.petersil98.fade.data.gunbuddy.GunBuddy;
import net.petersil98.fade.data.gunbuddy.GunBuddyLevel;
import net.petersil98.fade.data.spray.Spray;
import net.petersil98.fade.data.spray.SprayLevel;
import net.petersil98.fade.data.weapon.*;
import net.petersil98.fade.model.match.MatchDetails;

import java.awt.*;
import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.stream.StreamSupport;

public class Deserializers {

    public static final ObjectMapper MAPPER = new ObjectMapper();

    public static class AgentDeserializer extends JsonDeserializer<Agent> {

        @Override
        public Agent deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            JsonNode root = jp.getCodec().readTree(jp);
            List<Color> colors = StreamSupport.stream(root.get("backgroundGradientColors").spliterator(), false)
                    .map(JsonNode::asText)
                    .map(Deserializers::getRGBAColorFromHexString)
                    .toList();

            return new Agent(root.get("uuid").asText(), root.get("displayName").asText(), root.get("description").asText(),
                    root.get("characterTags").isEmpty() ? List.of() :
                            MAPPER.readerForListOf(String.class).readValue(root.get("characterTags")),
                    root.get("displayIcon").asText(), root.get("displayIconSmall").asText(),
                    root.get("bustPortrait").asText(), root.get("fullPortrait").asText(),
                    root.get("fullPortraitV2").asText(), root.get("killfeedPortrait").asText(),
                    root.get("background").asText(), colors, root.get("isFullPortraitRightFacing").asBoolean(),
                    root.get("isBaseContent").isArray(), MAPPER.readerFor(Role.class).readValue(root.get("role")),
                    MAPPER.readerForListOf(Agent.Ability.class).readValue(root.get("abilities")),
                    MAPPER.readerFor(Agent.VoiceLine.class).readValue(root.get("voiceLine")));
        }
    }

    public static class GunBuddyDeserializer extends JsonDeserializer<GunBuddy> {

        @Override
        public GunBuddy deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            JsonNode root = jp.getCodec().readTree(jp);
            List<GunBuddyLevel> levels = StreamSupport.stream(root.get("levels").spliterator(), false)
                    .map(node -> GunBuddyLevels.getGunBuddyLevel(node.get("uuid").asText())).toList();

            return new GunBuddy(root.get("uuid").asText(), root.get("displayName").asText(),
                    root.get("isHiddenIfNotOwned").asBoolean(), Themes.getTheme(root.get("themeUuid").asText(null)),
                    root.get("displayIcon").asText(), levels);
        }
    }

    public static class TierDeserializer extends JsonDeserializer<CompetitiveTier.Tier> {

        @Override
        public CompetitiveTier.Tier deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            JsonNode root = jp.getCodec().readTree(jp);
            return new CompetitiveTier.Tier(root.get("tier").asInt(), root.get("tierName").asText(), root.get("divisionName").asText(),
                    getRGBAColorFromHexString(root.get("color").asText()),
                    getRGBAColorFromHexString(root.get("backgroundColor").asText()),
                    root.get("smallIcon").asText(null),
                    root.get("largeIcon").asText(null),
                    root.get("rankTriangleDownIcon").asText(null),
                    root.get("rankTriangleUpIcon").asText(null));
        }
    }

    public static class ContentTierDeserializer extends JsonDeserializer<ContentTier> {

        @Override
        public ContentTier deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            JsonNode root = jp.getCodec().readTree(jp);
            return new ContentTier(root.get("uuid").asText(), root.get("displayName").asText(), root.get("rank").asInt(),
                    root.get("juiceValue").asInt(), root.get("juiceCost").asInt(),
                    getRGBAColorFromHexString(root.get("highlightColor").asText()), root.get("displayIcon").asText());
        }
    }

    public static class ContentDeserializer extends JsonDeserializer<Contract.Content<?>> {

        @Override
        public Contract.Content<?> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            JsonNode root = jp.getCodec().readTree(jp);

            List<Contract.Chapter> chapters = MAPPER.readerForListOf(Contract.Chapter.class).readValue(root.get("chapters"));
            String contentType = root.get("relationType").asText("None");
            switch (contentType) {
                case "Agent" -> {return new Contract.Content<>(Agents.getAgent(root.get("relationUuid").asText()),
                        Contract.ContentType.AGENT, chapters);}
                case "Event" -> {return new Contract.Content<>(Events.getEvent(root.get("relationUuid").asText()),
                        Contract.ContentType.EVENT, chapters);}
                case "Season" -> {return new Contract.Content<>(Seasons.getSeason(root.get("relationUuid").asText()),
                        Contract.ContentType.SEASON, chapters);}
                case "None" -> {return new Contract.Content<>(null, Contract.ContentType.NONE, chapters);}
            }
            return null;
        }
    }

    public static class RewardDeserializer extends JsonDeserializer<Contract.Reward<?>> {

        @Override
        public Contract.Reward<?> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            JsonNode root = jp.getCodec().readTree(jp);
            switch (root.get("type").asText()) {
                case "Spray" -> {return new Contract.Reward<>(Contract.RewardType.SPRAY,
                        Sprays.getSpray(root.get("uuid").asText()),
                        root.get("amount").asInt(), root.get("isHighlighted").asBoolean());}
                case "Title" -> {return new Contract.Reward<>(Contract.RewardType.TITLE,
                        PlayerTitles.getPlayerTitle(root.get("uuid").asText()),
                        root.get("amount").asInt(), root.get("isHighlighted").asBoolean());}
                case "PlayerCard" -> {return new Contract.Reward<>(Contract.RewardType.PLAYER_CARD,
                        PlayerCards.getPlayerCard(root.get("uuid").asText()),
                        root.get("amount").asInt(), root.get("isHighlighted").asBoolean());}
                case "Currency" -> {return new Contract.Reward<>(Contract.RewardType.CURRENCY,
                        Currencies.getCurrency(root.get("uuid").asText()),
                        root.get("amount").asInt(), root.get("isHighlighted").asBoolean());}
                case "EquippableSkinLevel" -> {return new Contract.Reward<>(Contract.RewardType.EQUIPPABLE_SKIN_LEVEL,
                        WeaponSkinLevels.getWeaponSkinLevel(root.get("uuid").asText()),
                        root.get("amount").asInt(), root.get("isHighlighted").asBoolean());}
                case "EquippableCharmLevel" -> {return new Contract.Reward<>(Contract.RewardType.EQUIPPABLE_CHARM_LEVEL,
                        GunBuddyLevels.getGunBuddyLevel(root.get("uuid").asText()),
                        root.get("amount").asInt(), root.get("isHighlighted").asBoolean());}
            }
            return null;
        }
    }

    public static class EventDeserializer extends JsonDeserializer<Event> {

        @Override
        public Event deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            JsonNode root = jp.getCodec().readTree(jp);

            long startTime = Instant.parse(root.get("startTime").asText()).getEpochSecond();
            long endTime = Instant.parse(root.get("endTime").asText()).getEpochSecond();
            return new Event(root.get("uuid").asText(), root.get("displayName").asText(), startTime, endTime);
        }
    }

    public static class PlayerCardDeserializer extends JsonDeserializer<PlayerCard> {

        @Override
        public PlayerCard deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            JsonNode root = jp.getCodec().readTree(jp);

            return new PlayerCard(root.get("uuid").asText(), root.get("displayName").asText(), root.get("isHiddenIfNotOwned").asBoolean(),
                    Themes.getTheme(root.get("themeUuid").asText(null)), root.get("displayIcon").asText(),
                    root.get("smallArt").asText(), root.get("wideArt").asText(), root.get("largeArt").asText());
        }
    }

    public static class SeasonDeserializer extends JsonDeserializer<Season> {

        @Override
        public Season deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            JsonNode root = jp.getCodec().readTree(jp);

            long startTime = Instant.parse(root.get("startTime").asText()).getEpochSecond();
            long endTime = Instant.parse(root.get("endTime").asText()).getEpochSecond();
            return new Season(root.get("uuid").asText(), root.get("displayName").asText(), startTime, endTime);
        }
    }

    public static class CompetitiveSeasonDeserializer extends JsonDeserializer<CompetitiveSeason> {

        @Override
        public CompetitiveSeason deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            JsonNode root = jp.getCodec().readTree(jp);

            long startTime = Instant.parse(root.get("startTime").asText()).getEpochSecond();
            long endTime = Instant.parse(root.get("endTime").asText()).getEpochSecond();
            return new CompetitiveSeason(root.get("uuid").asText(), startTime, endTime,
                    Seasons.getSeason(root.get("seasonUuid").asText(null)),
                    CompetitiveTiers.getCompetitiveTier(root.get("competitiveTiersUuid").asText(null)),
                    MAPPER.readerForListOf(CompetitiveSeason.Border.class).readValue(root.get("borders")));
        }
    }

    public static class SprayDeserializer extends JsonDeserializer<Spray> {

        @Override
        public Spray deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            JsonNode root = jp.getCodec().readTree(jp);
            List<SprayLevel> levels = StreamSupport.stream(root.get("levels").spliterator(), false)
                    .map(node -> SprayLevels.getSprayLevel(node.get("uuid").asText())).toList();

            return new Spray(root.get("uuid").asText(), root.get("displayName").asText(),
                    Themes.getTheme(root.get("themeUuid").asText(null)), root.get("isNullSpray").booleanValue(),
                    root.get("displayIcon").asText(null), root.get("fullIcon").asText(null), root.get("fullTransparentIcon").asText(null),
                    root.get("animationPng").asText(null), root.get("animationGif").asText(null), levels);
        }
    }

    public static class WeaponSkinDeserializer extends JsonDeserializer<WeaponSkin> {

        @Override
        public WeaponSkin deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            JsonNode root = jp.getCodec().readTree(jp);
            List<WeaponSkinChroma> chromas = StreamSupport.stream(root.get("chromas").spliterator(), false)
                    .map(node -> WeaponSkinChromas.getWeaponSkinChroma(node.get("uuid").asText())).toList();
            List<WeaponSkinLevel> levels = StreamSupport.stream(root.get("levels").spliterator(), false)
                    .map(node -> WeaponSkinLevels.getWeaponSkinLevel(node.get("uuid").asText())).toList();

            return new WeaponSkin(root.get("uuid").asText(), root.get("displayName").asText(),
                    Themes.getTheme(root.get("themeUuid").asText(null)),
                    ContentTiers.getContentTier(root.get("contentTierUuid").asText(null)),
                    root.get("displayIcon").asText(null), root.get("wallpaper").asText(null),
                    chromas, levels);
        }
    }

    public static class WeaponDeserializer extends JsonDeserializer<Weapon> {

        @Override
        public Weapon deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            JsonNode root = jp.getCodec().readTree(jp);
            List<WeaponSkin> skins = StreamSupport.stream(root.get("skins").spliterator(), false)
                    .map(node -> WeaponSkins.getWeaponSkin(node.get("uuid").asText())).toList();

            return new Weapon(root.get("uuid").asText(), root.get("displayName").asText(),
                    WeaponSkins.getWeaponSkin(root.get("defaultSkinUuid").asText(null)),
                    root.get("displayIcon").asText(null), root.get("killStreamIcon").asText(null),
                    MAPPER.readerFor(Weapon.Stats.class).readValue(root.get("weaponStats")),
                    MAPPER.readerFor(ShopData.class).readValue(root.get("shopData")), skins);
        }
    }

    public static class LeaderboardDeserializer extends JsonDeserializer<Leaderboard> {

        @Override
        public Leaderboard deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            JsonNode root = jp.getCodec().readTree(jp);
            List<RankEntry> players = MAPPER.readerForListOf(RankEntry.class).readValue(root.get("players"));
            return new Leaderboard(players, root.get("totalPlayers").asInt(), root.get("immortalStartingPage").asInt(),
                    root.get("immortalStartingIndex").asInt(), root.get("topTierRRThreshold").asInt());
        }
    }

    public static class MatchDetailsDeserializer extends JsonDeserializer<MatchDetails> {

        @Override
        public MatchDetails deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            JsonNode root = jp.getCodec().readTree(jp);
            return null;
        }
    }

    private static Color getRGBAColorFromHexString(String hexColor) {
        int color = Integer.parseUnsignedInt(hexColor, 16);
        int r = (color >> 24) & 0xFF;
        int g = (color >> 16) & 0xFF;
        int b = (color >> 8)  & 0xFF;
        int a = (color)       & 0xFF;
        return new Color(r, g, b, a);
    }
}
