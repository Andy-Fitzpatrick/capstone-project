package org.launchcode.capstoneproject.models;

import java.util.Objects;

public class Supply {

    private int id;
    private static int nextId = 1;

    private String name;
    private String description;

    public Supply(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supply supply = (Supply) o;
        return id == supply.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
