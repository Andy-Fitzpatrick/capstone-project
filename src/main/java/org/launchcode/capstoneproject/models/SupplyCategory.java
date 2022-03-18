package org.launchcode.capstoneproject.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SupplyCategory extends AbstractEntity{

    private String name;

    @OneToMany(mappedBy = "supplyCategory")
    private final List<Supply> supplies = new ArrayList<>();

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

    public List<Supply> getSupplies() {
        return supplies;
    }

    @Override
    public String toString() {
        return name;
    }

}
