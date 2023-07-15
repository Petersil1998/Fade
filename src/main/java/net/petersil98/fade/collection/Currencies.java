package net.petersil98.fade.collection;

import net.petersil98.fade.data.Currency;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Currencies {

    private static Map<String, Currency> currencies;

    public static Currency getCurrency(String id) {
        return currencies.get(id);
    }

    public static List<Currency> getCurrencies() {
        return new ArrayList<>(currencies.values());
    }
}
