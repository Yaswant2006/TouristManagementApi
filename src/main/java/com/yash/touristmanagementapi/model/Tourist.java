package com.yash.touristmanagementapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Schema(name = "Tourist", description = "Details about the Tourist")
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Schema(description = "Full name of the user", example = "John Doe")
    private String name;

    @Schema(description = "Origin of the user", example = "Rayagada")
    private String origin;

    @Schema(description = "Destination of the user", example = "Sambalpur")
    private String destination;

    @Schema(description = "Package of the user", example = "Platinum/Gold/Silver")
    private String packageType;

    @Schema(description = "Budget of the user", example = "59000.05")
    private double budget;

    public Tourist() {
    }

    public Tourist(Integer id, String name, String origin, String destination, String packageType, double budget) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.destination = destination;
        this.packageType = packageType;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Tourist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", packageType='" + packageType + '\'' +
                ", budget=" + budget +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
