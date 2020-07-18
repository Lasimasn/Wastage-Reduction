package com.stackroute.domain;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "LINKED_TO")
public class PropertiesRD {

    @Id @GeneratedValue private Long id;

    @StartNode
    private Restaurant restaurant;

    @EndNode
    private DeliveryBoy deliveryBoy;

    private double distance;

    public PropertiesRD() {
    }

    public PropertiesRD(Long id, double distance, Restaurant restaurant) {
        this.id = id;
        this.restaurant = restaurant;
        this.distance=distance;

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

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
