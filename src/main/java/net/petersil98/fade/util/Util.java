package net.petersil98.fade.util;

import net.petersil98.core.util.InvalidFilterException;

public class Util {

    public static void validateFilter(java.util.Map<String, String> filter) {
        filter.forEach((filterName, arg) -> {
            switch (filterName) {
                case "size" -> {
                    try {
                        int size = Integer.parseInt(arg);
                        if (size < 1 || size > 200) throw new InvalidFilterException("size must be between 1 and 200");
                    } catch (NumberFormatException e) {
                        throw new InvalidFilterException("Filter \"" + arg + "\" isn't a number", e);
                    }
                }
                case "startIndex" -> {
                    try {
                        Integer.parseInt(arg);
                    } catch (NumberFormatException e) {
                        throw new InvalidFilterException("Filter \"" + arg + "\" isn't a number", e);
                    }
                }
                default -> throw new InvalidFilterException("Unknown filter \"" + filterName + "\" for match history");
            }
        });
    }
}
