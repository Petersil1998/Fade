package net.petersil98.fade.collection.agent;

import net.petersil98.fade.data.agent.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Roles {

    private static Map<String, Role> roles;

    public static Role getRole(String id) {
        return roles.get(id);
    }

    public static List<Role> getRoles() {
        return new ArrayList<>(roles.values());
    }
}
