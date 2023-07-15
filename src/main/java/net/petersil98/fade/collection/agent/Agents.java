package net.petersil98.fade.collection.agent;

import net.petersil98.fade.data.agent.Agent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Agents {

    private static Map<String, Agent> agents;

    public static Agent getAgent(String id) {
        return agents.get(id);
    }

    public static List<Agent> getAgents() {
        return new ArrayList<>(agents.values());
    }
}
