package com.stackroute.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
public class Charity {

    @Id @GeneratedValue private Long id;
    private String charityId;
    private String charityName;
    private String foodRequirement;
    private String location;
    private String foodAvailable;
    private double precedence;

    public Charity() {
    }

    @JsonIgnoreProperties("charity")
    @Relationship(type = "DONATES_TO", direction = Relationship.INCOMING)
    private List<Restaurant> restaurants;

    @Relationship(type = "DONATES_TO", direction = Relationship.INCOMING)
    private List<PropertiesRC> propertiesRC;


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

    public String getFoodRequirement() { return foodRequirement; }

    public void setFoodRequirement(String foodRequirement) { this.foodRequirement = foodRequirement; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public String getFoodAvailable() { return foodAvailable; }

    public void setFoodAvailable(String foodAvailable) { this.foodAvailable = foodAvailable; }

    public double getPrecedence() { return precedence; }

    public void setPrecedence(double precedence) { this.precedence = precedence; }

//    public List<PropertiesRC> getPropertiesRC() { return propertiesRC; }
//
//    public void setPropertiesRC(List<PropertiesRC> propertiesRC) { this.propertiesRC = propertiesRC; }
//
//    public List<Restaurant> getRestaurants() {
//        return restaurants;
//    }
//
//    public void setRestaurants(List<Restaurant> restaurants) {
//        this.restaurants = restaurants;
//    }

}
