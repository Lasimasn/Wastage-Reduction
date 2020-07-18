package com.stackroute.domain;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "DONATES_TO")
public class PropertiesRC {

    @Id @GeneratedValue private Long id;
    private double distance;
    private String status;

    @StartNode
    private Restaurant restaurant;

    @EndNode
    private Charity charity;

    public PropertiesRC() {
    }

    public PropertiesRC(Long id, double distance, String status, Restaurant restaurant) {
        this.id = id;
        this.distance=distance;
        this.status=status;
        this.restaurant = restaurant;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
