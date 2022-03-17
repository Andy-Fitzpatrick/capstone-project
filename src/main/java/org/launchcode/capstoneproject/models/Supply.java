package org.launchcode.capstoneproject.models;

import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Supply {

    @Id
    @GeneratedValue
    private int id;

    private static int nextId = 1;

    @NotBlank(message = "Name is required")
    @Size(min = 2, message = "Name must be more than 2 characters")
    private String name;

    @Size(max = 500, message = "Description is too long")
    private String description;

    private String location;

    private String color;

    private String amount;

    private String brand;

    public Supply(String name, String description, String location, String color,
                  String amount, String brand) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.color = color;
        this.amount = amount;
        this.brand = brand;
        this.id = nextId;
        nextId++;
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
