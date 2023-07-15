package net.petersil98.fade.data;

import net.petersil98.fade.collection.Seasons;
import net.petersil98.fade.util.ValLoader;

import java.util.Objects;

public class Season {

    private final String id;
    private final String name;
    private final long startTime;
    private final long endTime;
    private Season parent;

    public Season(String id, String name, long startTime, long endTime) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void postInit() {
        if(ValLoader.PARENT_SEASONS.containsKey(this.id)) {
            this.parent = Seasons.getSeason(ValLoader.PARENT_SEASONS.get(this.id));
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public Season getParent() {
        return parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Season season = (Season) o;
        return Objects.equals(id, season.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
