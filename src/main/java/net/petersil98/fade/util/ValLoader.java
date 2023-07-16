package net.petersil98.fade.util;

import com.fasterxml.jackson.databind.JsonNode;
import net.petersil98.core.Core;
import net.petersil98.core.util.Loader;
import net.petersil98.core.util.settings.Language;
import net.petersil98.core.util.settings.Settings;
import net.petersil98.fade.Fade;
import net.petersil98.fade.collection.*;
import net.petersil98.fade.collection.agent.Agents;
import net.petersil98.fade.collection.agent.Roles;
import net.petersil98.fade.collection.gunbuddy.GunBuddies;
import net.petersil98.fade.collection.gunbuddy.GunBuddyLevels;
import net.petersil98.fade.collection.spray.SprayLevels;
import net.petersil98.fade.collection.spray.Sprays;
import net.petersil98.fade.collection.weapon.*;
import net.petersil98.fade.constants.ValConstants;
import net.petersil98.fade.data.*;
import net.petersil98.fade.data.agent.Agent;
import net.petersil98.fade.data.agent.Role;
import net.petersil98.fade.data.gunbuddy.GunBuddy;
import net.petersil98.fade.data.gunbuddy.GunBuddyLevel;
import net.petersil98.fade.data.spray.Spray;
import net.petersil98.fade.data.spray.SprayLevel;
import net.petersil98.fade.data.weapon.*;
import org.apache.logging.log4j.core.util.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URI;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static net.petersil98.fade.model.Deserializers.MAPPER;

public class ValLoader extends Loader {

    private static String latestValAPIVersion;
    private static Language usedLanguage;

    public static final Map<String, String> PARENT_SEASONS = new HashMap<>();

    @Override
    protected void load() {
        if(latestValAPIVersion == null) loadLatestVersions();
        usedLanguage = getLanguageToUse();
        loadAgentsAndRoles();
        loadGunBuddyLevels();
        loadThemes();
        loadGunBuddies();
        loadBundles();
        loadCeremonies();
        loadCompetitiveTiers();
        loadContentTiers();
        loadCurrencies();
        loadEvents();
        loadGameModes();
        loadShields();
        loadLevelBorders();
        loadMaps();
        loadPlayerCards();
        loadPlayerTitles();
        loadSeasons();
        loadCompetitiveSeasons();
        loadSprayLevels();
        loadSprays();
        loadWeaponSkinLevels();
        loadWeaponSkinChromas();
        loadWeaponSkins();
        loadWeapons();
        loadContracts();
    }

    @Override
    protected boolean shouldReloadData() {
        if(usedLanguage != getLanguageToUse()) return true;
        try(InputStream lolVersion = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/version").toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(IOUtils.toString(new InputStreamReader(lolVersion)));
            String version = root.get("data").get("version").asText();
            if(!latestValAPIVersion.equals(version)) {
                latestValAPIVersion = version;
                return true;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    private Language getLanguageToUse() {
        return Settings.getLanguage().isAvailableForVal() ? Settings.getLanguage() : Language.EN_US;
    }

    private static void loadLatestVersions() {
        try(InputStream lolVersion = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/version").toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(lolVersion);
            latestValAPIVersion = root.get("data").get("version").asText();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadAgentsAndRoles() {
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/agents?isPlayableCharacter=true&language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<Agent> agents = MAPPER.readerForListOf(Agent.class).readValue(root.get("data"));
            Set<Role> roles = agents.stream().map(Agent::getRole).collect(Collectors.toSet());

            setFieldInCollection(Agents.class, agents.stream().collect(Collectors.toMap(Agent::getId, agent -> agent)));
            setFieldInCollection(Roles.class, roles.stream().collect(Collectors.toMap(Role::getId, role -> role)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadGunBuddyLevels() {
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/buddies/levels?language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<GunBuddyLevel> gunBuddyLevels = MAPPER.readerForListOf(GunBuddyLevel.class).readValue(root.get("data"));
            setFieldInCollection(GunBuddyLevels.class, gunBuddyLevels.stream().collect(Collectors.toMap(GunBuddyLevel::getId, buddyLevel -> buddyLevel)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadThemes() {
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/themes?language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<Theme> themes = MAPPER.readerForListOf(Theme.class).readValue(root.get("data"));
            setFieldInCollection(Themes.class, themes.stream().collect(Collectors.toMap(Theme::getId, theme -> theme)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadGunBuddies() {
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/buddies?language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<GunBuddy> buddies = MAPPER.readerForListOf(GunBuddy.class).readValue(root.get("data"));
            setFieldInCollection(GunBuddies.class, buddies.stream().collect(Collectors.toMap(GunBuddy::getId, buddy -> buddy)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadBundles() {
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/bundles?language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<Bundle> bundles = MAPPER.readerForListOf(Bundle.class).readValue(root.get("data"));
            setFieldInCollection(Bundles.class, bundles.stream().collect(Collectors.toMap(Bundle::getId, bundle -> bundle)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCeremonies() {
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/ceremonies?language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<Ceremony> ceremonies = MAPPER.readerForListOf(Ceremony.class).readValue(root.get("data"));
            setFieldInCollection(Ceremonies.class, ceremonies.stream().collect(Collectors.toMap(Ceremony::getId, ceremony -> ceremony)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCompetitiveTiers() {
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/competitivetiers?language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<CompetitiveTier> competitiveTiers = MAPPER.readerForListOf(CompetitiveTier.class).readValue(root.get("data"));
            setFieldInCollection(CompetitiveTiers.class, competitiveTiers.stream().collect(Collectors.toMap(CompetitiveTier::getId, competitiveTier -> competitiveTier)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadContentTiers() {
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/contenttiers?language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<ContentTier> contentTiers = MAPPER.readerForListOf(ContentTier.class).readValue(root.get("data"));
            setFieldInCollection(ContentTiers.class, contentTiers.stream().collect(Collectors.toMap(ContentTier::getId, contentTier -> contentTier)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadContracts() {
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/contracts?language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<Contract> contracts = MAPPER.readerForListOf(Contract.class).readValue(root.get("data"));
            setFieldInCollection(Contracts.class, contracts.stream().collect(Collectors.toMap(Contract::getId, contract -> contract)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCurrencies() {
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/currencies?language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<Currency> currencies = MAPPER.readerForListOf(Currency.class).readValue(root.get("data"));
            setFieldInCollection(Currencies.class, currencies.stream().collect(Collectors.toMap(Currency::getId, currency -> currency)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadEvents() {
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/events?language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<Event> events = MAPPER.readerForListOf(Event.class).readValue(root.get("data"));
            setFieldInCollection(Events.class, events.stream().collect(Collectors.toMap(Event::getId, event -> event)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadGameModes() {
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/gamemodes?language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<GameMode> gameModes = MAPPER.readerForListOf(GameMode.class).readValue(root.get("data"));
            setFieldInCollection(GameModes.class, gameModes.stream().collect(Collectors.toMap(GameMode::getId, gameMode -> gameMode)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadShields() {
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/gear?language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<Shield> shields = MAPPER.readerForListOf(Shield.class).readValue(root.get("data"));
            setFieldInCollection(Shields.class, shields.stream().collect(Collectors.toMap(Shield::getId, shield -> shield)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadLevelBorders() {
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/levelborders").toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<LevelBorder> levelBorders = MAPPER.readerForListOf(LevelBorder.class).readValue(root.get("data"));
            setFieldInCollection(LevelBorders.class, levelBorders.stream().collect(Collectors.toMap(LevelBorder::getId, levelBorder -> levelBorder)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMaps() {
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/maps?language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<net.petersil98.fade.data.Map> maps = MAPPER.readerForListOf(net.petersil98.fade.data.Map.class).readValue(root.get("data"));
            setFieldInCollection(Maps.class, maps.stream().collect(Collectors.toMap(net.petersil98.fade.data.Map::getId, map -> map)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPlayerCards() {
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/playercards?language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<PlayerCard> playerCards = MAPPER.readerForListOf(PlayerCard.class).readValue(root.get("data"));
            setFieldInCollection(PlayerCards.class, playerCards.stream().collect(Collectors.toMap(PlayerCard::getId, playerCard -> playerCard)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPlayerTitles() {
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/playertitles?language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<PlayerTitle> playerTitles = MAPPER.readerForListOf(PlayerTitle.class).readValue(root.get("data"));
            setFieldInCollection(PlayerTitles.class, playerTitles.stream().collect(Collectors.toMap(PlayerTitle::getId, playerTitle -> playerTitle)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadSeasons() {
        PARENT_SEASONS.clear();
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/seasons?language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            Map<String, Season> seasons = new HashMap<>();
            for(JsonNode node: root.get("data")) {
                Season season = MAPPER.readerFor(Season.class).readValue(node);
                seasons.put(season.getId(), season);
                PARENT_SEASONS.put(season.getId(), node.get("parentUuid").asText(null));
            }
            setFieldInCollection(Seasons.class, seasons);
            Seasons.getSeasons().forEach(Season::postInit);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCompetitiveSeasons() {
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/seasons/competitive?language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<CompetitiveSeason> competitiveSeasons = MAPPER.readerForListOf(CompetitiveSeason.class).readValue(root.get("data"));
            setFieldInCollection(CompetitiveSeasons.class, competitiveSeasons.stream().collect(Collectors.toMap(CompetitiveSeason::getId, season -> season)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadSprayLevels() {
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/sprays/levels?language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<SprayLevel> sprayLevels = MAPPER.readerForListOf(SprayLevel.class).readValue(root.get("data"));
            setFieldInCollection(SprayLevels.class, sprayLevels.stream().collect(Collectors.toMap(SprayLevel::getId, sprayLevel -> sprayLevel)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadSprays() {
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/sprays?language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<Spray> sprays = MAPPER.readerForListOf(Spray.class).readValue(root.get("data"));
            setFieldInCollection(Sprays.class, sprays.stream().collect(Collectors.toMap(Spray::getId, spray -> spray)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadWeaponSkinLevels() {
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/weapons/skinlevels?language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<WeaponSkinLevel> weaponSkinLevels = MAPPER.readerForListOf(WeaponSkinLevel.class).readValue(root.get("data"));
            setFieldInCollection(WeaponSkinLevels.class, weaponSkinLevels.stream().collect(Collectors.toMap(WeaponSkinLevel::getId, skinLevel -> skinLevel)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadWeaponSkinChromas() {
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/weapons/skinchromas?language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<WeaponSkinChroma> weaponSkinChromas = MAPPER.readerForListOf(WeaponSkinChroma.class).readValue(root.get("data"));
            setFieldInCollection(WeaponSkinChromas.class, weaponSkinChromas.stream().collect(Collectors.toMap(WeaponSkinChroma::getId, skinChroma -> skinChroma)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadWeaponSkins() {
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/weapons/skins?language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<WeaponSkin> weaponSkins = MAPPER.readerForListOf(WeaponSkin.class).readValue(root.get("data"));
            setFieldInCollection(WeaponSkins.class, weaponSkins.stream().collect(Collectors.toMap(WeaponSkin::getId, skin -> skin)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadWeapons() {
        String lang = usedLanguage.toString().replace("_", "-");
        try(InputStream in = URI.create(ValConstants.VAL_API_BASE_PATH + "v1/weapons?language=" + lang).toURL().openConnection().getInputStream()) {
            JsonNode root = Core.MAPPER.readTree(in);
            List<Weapon> weapons = MAPPER.readerForListOf(Weapon.class).readValue(root.get("data"));
            setFieldInCollection(Weapons.class, weapons.stream().collect(Collectors.toMap(Weapon::getId, weapon -> weapon)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setFieldInCollection(Class<?> collectionClass, Map<?, ?> elements) {
        try {
            char[] fieldName = collectionClass.getSimpleName().toCharArray();
            fieldName[0] += 32;
            Field field = collectionClass.getDeclaredField(new String(fieldName));
            field.setAccessible(true);
            field.set(null, elements);
            field.setAccessible(false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            Fade.LOGGER.error("Couldn't set collection Type of class " + collectionClass.getSimpleName(), e);
        }
    }
}
