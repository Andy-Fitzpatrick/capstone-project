package org.launchcode.capstoneproject.data;

import org.launchcode.capstoneproject.models.Supply;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SupplyData {

    private static final Map<Integer, Supply> supplies = new HashMap<>();

    public static Collection<Supply> getAll() {
        return supplies.values();
    }

    public static Supply getByID(int id) {
        return supplies.get(id);
    }

    public static void add(Supply supply) {
        supplies.put(supply.getId(), supply);
    }

    public static void remove(int id) {
        supplies.remove(id);
    }

}
