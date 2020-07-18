package com.stackroute.domain;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "LINKED_TO")
public class PropertiesDC {

    @Id @GeneratedValue private Long id;

    @StartNode
    private DeliveryBoy deliveryBoy;

    @EndNode
    private Charity charity;

    private double distance;

    public PropertiesDC() {
    }

    public PropertiesDC(Long id, Charity charity, double distance) {
        this.id = id;
        this.charity=charity;
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

    public Charity getCharity() {
        return charity;
    }

    public void setCharity(Charity charity) {
        this.charity = charity;
    }

}
