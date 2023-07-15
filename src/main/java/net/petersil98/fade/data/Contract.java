package net.petersil98.fade.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.petersil98.fade.data.agent.Agent;
import net.petersil98.fade.data.gunbuddy.GunBuddyLevel;
import net.petersil98.fade.data.spray.Spray;
import net.petersil98.fade.data.weapon.WeaponSkin;
import net.petersil98.fade.data.weapon.WeaponSkinLevel;
import net.petersil98.fade.model.Deserializers;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Contract {

    @JsonProperty("uuid")
    private String id;
    @JsonProperty("displayName")
    private String name;
    private String displayIcon;
    private String freeRewardScheduleUuid;
    private Content<?> content;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDisplayIcon() {
        return displayIcon;
    }

    public String getFreeRewardScheduleUuid() {
        return freeRewardScheduleUuid;
    }

    public Content<?> getContent() {
        return content;
    }

    @JsonDeserialize(using = Deserializers.ContentDeserializer.class)
    public static class Content<T> {
        private final T reference;
        private final ContentType<T> contentType;
        private final List<Chapter> chapters;

        public Content(T reference, ContentType<T> contentType, List<Chapter> chapters) {
            this.reference = reference;
            this.contentType = contentType;
            this.chapters = chapters;
        }

        public T getReference() {
            return reference;
        }

        public ContentType<T> getContentType() {
            return contentType;
        }

        public List<Chapter> getChapters() {
            return chapters;
        }
    }

    public static class Chapter {

        @JsonProperty("isEpilogue")
        private boolean isEpilogue;
        private List<Level> levels;
        private List<Reward<?>> freeRewards;

        public boolean isEpilogue() {
            return isEpilogue;
        }

        public List<Level> getLevels() {
            return levels;
        }

        public List<Reward<?>> getFreeRewards() {
            return freeRewards;
        }
    }

    public static class Level {
        private Reward<?> reward;
        private int xp;
        private int vpCost;
        @JsonProperty("isPurchasableWithVP")
        private boolean isPurchasableWithVP;
        private int doughCost;
        @JsonProperty("isPurchasableWithDough")
        private boolean isPurchasableWithDough;

        public Reward<?> getReward() {
            return reward;
        }

        public int getXp() {
            return xp;
        }

        public int getVpCost() {
            return vpCost;
        }

        public boolean isPurchasableWithVP() {
            return isPurchasableWithVP;
        }

        public int getDoughCost() {
            return doughCost;
        }

        public boolean isPurchasableWithDough() {
            return isPurchasableWithDough;
        }
    }

    @JsonDeserialize(using = Deserializers.RewardDeserializer.class)
    public static class Reward<T> {
        private final RewardType<T> type;
        private final T item;
        private final int amount;
        private final boolean isHighlighted;

        public Reward(RewardType<T> type, T item, int amount, boolean isHighlighted) {
            this.type = type;
            this.item = item;
            this.amount = amount;
            this.isHighlighted = isHighlighted;
        }

        public RewardType<T> getType() {
            return type;
        }

        public T getItem() {
            return item;
        }

        public int getAmount() {
            return amount;
        }

        public boolean isHighlighted() {
            return isHighlighted;
        }
    }

    public static class RewardType<T> {
        public static final RewardType<Spray> SPRAY = new RewardType<>();
        public static final RewardType<PlayerTitle> TITLE = new RewardType<>();
        public static final RewardType<PlayerCard> PLAYER_CARD = new RewardType<>();
        public static final RewardType<WeaponSkinLevel> EQUIPPABLE_SKIN_LEVEL = new RewardType<>();
        public static final RewardType<Currency> CURRENCY = new RewardType<>();
        public static final RewardType<GunBuddyLevel> EQUIPPABLE_CHARM_LEVEL = new RewardType<>();

        private RewardType() {}
    }

    public static class ContentType<T> {
        public static final ContentType<Agent> AGENT = new ContentType<>();
        public static final ContentType<Event> EVENT = new ContentType<>();
        public static final ContentType<Season> SEASON = new ContentType<>();
        public static final ContentType<Void> NONE = new ContentType<>();

        private ContentType() {}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return Objects.equals(id, contract.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
