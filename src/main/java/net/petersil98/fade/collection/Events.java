package net.petersil98.fade.collection;

import net.petersil98.fade.data.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Events {

    private static Map<String, Event> events;

    public static Event getEvent(String id) {
        return events.get(id);
    }

    public static List<Event> getEvents() {
        return new ArrayList<>(events.values());
    }
}
