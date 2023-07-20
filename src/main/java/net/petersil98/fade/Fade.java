package net.petersil98.fade;

import net.petersil98.core.util.Loader;
import net.petersil98.core.util.settings.Language;
import net.petersil98.core.util.settings.Settings;
import net.petersil98.fade.collection.Contracts;
import net.petersil98.fade.collection.Seasons;
import net.petersil98.fade.constants.ValRegion;
import net.petersil98.fade.data.Contract;
import net.petersil98.fade.model.Leaderboard;
import net.petersil98.fade.model.ValRanked;
import net.petersil98.fade.util.ValLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Fade {

    public static final Logger LOGGER = LogManager.getLogger(Fade.class);

    public static void main(String[] args) {
        Settings.setLanguage(Language.EN_US);
        Settings.setAPIKey(() -> System.getenv("API_KEY"));
        Loader.addLoader(new ValLoader());
        Loader.init();
        System.out.println(Contracts.getContractsOfType(Contract.ContentType.AGENT));
        Leaderboard leaderboard = ValRanked.getLeaderboard(ValRegion.EU, Seasons.getEpisodeAct(2, 1).getId());
    }
}
