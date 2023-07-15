package net.petersil98.fade.collection;

import net.petersil98.fade.data.ContentTier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContentTiers {

    private static Map<Integer, ContentTier> contentTiers;

    public static ContentTier getContentTier(String id) {
        return contentTiers.get(id);
    }

    public static List<ContentTier> getContentTiers() {
        return new ArrayList<>(contentTiers.values());
    }
}
