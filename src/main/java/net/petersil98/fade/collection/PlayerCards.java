package net.petersil98.fade.collection;

import net.petersil98.fade.data.PlayerCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerCards {

    private static Map<String, PlayerCard> playerCards;

    public static PlayerCard getPlayerCard(String id) {
        return playerCards.get(id);
    }

    public static List<PlayerCard> getPlayerCards() {
        return new ArrayList<>(playerCards.values());
    }
}
