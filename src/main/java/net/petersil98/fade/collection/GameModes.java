package net.petersil98.fade.collection;

import net.petersil98.fade.data.GameMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameModes {

    private static Map<String, GameMode> gameModes;

    public static GameMode getGameMode(String id) {
        return gameModes.get(id);
    }

    public static List<GameMode> getGameModes() {
        return new ArrayList<>(gameModes.values());
    }
}
