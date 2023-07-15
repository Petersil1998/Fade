package net.petersil98.fade;

import net.petersil98.core.util.Loader;
import net.petersil98.core.util.settings.Language;
import net.petersil98.core.util.settings.Settings;
import net.petersil98.fade.collection.Contracts;
import net.petersil98.fade.data.Contract;
import net.petersil98.fade.util.ValLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Fade {

    public static final Logger LOGGER = LogManager.getLogger(Fade.class);

    public static void main(String[] args) {
        Settings.setLanguage(Language.EN_US);
        Loader.addLoader(new ValLoader());
        Loader.init();
        System.out.println(Contracts.getContractsOfType(Contract.ContentType.AGENT));
        System.out.println();
    }
}
