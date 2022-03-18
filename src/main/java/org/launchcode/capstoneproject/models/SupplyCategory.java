package org.launchcode.capstoneproject.models;

import javax.persistence.Entity;

@Entity
public class SupplyCategory extends AbstractEntity{

    private String name;

    public SupplyCategory(String name) {
        this.name = name;
    }

    public SupplyCategory() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
