package org.launchcode.capstoneproject.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Supply extends AbstractEntity {

    @NotBlank(message = "Name is required")
    @Size(min = 2, message = "Name must be more than 2 characters")
    private String name;

    @Size(max = 500, message = "Description is too long")
    private String description;

    private String location;

    private String color;

    private String amount;

    private String brand;

    @ManyToOne
    @NotNull(message = "Category is required")
    private SupplyCategory supplyCategory;

    public Supply(String name, String description, String location, String color,
                  String amount, String brand, SupplyCategory supplyCategory) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.color = color;
        this.amount = amount;
        this.brand = brand;
        this.supplyCategory = supplyCategory;
    }

    public Supply() {}

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public SupplyCategory getSupplyCategory() {
        return supplyCategory;
    }

    public void setSupplyCategory(SupplyCategory supplyCategory) {
        this.supplyCategory = supplyCategory;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
