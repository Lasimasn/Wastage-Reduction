package com.stackroute.domain;

import lombok.Data;

@Data
public class Charity {

    private String charityId;
    private String charityName;
    private String foodRequirement;
    private String location;
    private String foodAvailable;
    private double precedence;

    public Charity() {
    }

    public Charity(String charityId, String charityName, String foodRequirement, String location, String foodAvailable, double precedence) {
        this.charityId = charityId;
        this.charityName = charityName;
        this.foodRequirement = foodRequirement;
        this.location = location;
        this.foodAvailable = foodAvailable;
        this.precedence = precedence;
    }

    public String getCharityId() {
        return charityId;
    }

    public void setCharityId(String charityId) {
        this.charityId = charityId;
    }

    public String getCharityName() {
        return charityName;
    }

    public void setCharityName(String charityName) {
        this.charityName = charityName;
    }

    public String getFoodRequirement() {
        return foodRequirement;
    }

    public void setFoodRequirement(String foodRequirement) {
        this.foodRequirement = foodRequirement;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFoodAvailable() {
        return foodAvailable;
    }

    public void setFoodAvailable(String foodAvailable) {
        this.foodAvailable = foodAvailable;
    }

    public double getPrecedence() {
        return precedence;
    }

    public void setPrecedence(double precedence) {
        this.precedence = precedence;
    }
}
