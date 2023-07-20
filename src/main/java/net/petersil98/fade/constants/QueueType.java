package net.petersil98.fade.constants;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.petersil98.core.Core;

public enum QueueType {

    @JsonProperty("competitive")
    COMPETITIVE,
    @JsonProperty("unrated")
    UNRATED,
    @JsonProperty("spikerush")
    SPIKE_RUSH,
    @JsonProperty("tournamentmode")
    TOURNAMENT,
    @JsonProperty("deathmatch")
    DEATH_MATCH,
    @JsonProperty("onefa")
    ONE_FOR_ALL,
    @JsonProperty("ggteam")
    ESCALATION;

    /**
     * Utility Method to get the value of the {@link JsonProperty} Annotation
     * @return The value of the {@link JsonProperty} Annotation
     */
    public String getJsonPropertyValue() {
        try {
            return QueueType.class.getField(name()).getAnnotationsByType(JsonProperty.class)[0].value();
        } catch (NoSuchFieldException e) {
            Core.LOGGER.error("Couldn't get annotation value of QueueType type", e);
        }
        return name();
    }
}
