package net.petersil98.fade.collection;

import net.petersil98.fade.data.PlayerTitle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerTitles {

    private static Map<String, PlayerTitle> playerTitles;

    public static PlayerTitle getPlayerTitle(String id) {
        return playerTitles.get(id);
    }

    public static List<PlayerTitle> getPlayerTitles() {
        return new ArrayList<>(playerTitles.values());
    }
}
