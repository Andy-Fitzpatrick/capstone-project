package org.launchcode.capstoneproject.models;

public enum SupplyCategory {

    PERSONAL("Personal"),
    SCHOOL("School"),
    HOLIDAY("Holiday"),
    OTHER("Other");

    private final String name;

    SupplyCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
