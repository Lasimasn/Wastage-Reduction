package com.stackroute.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
public class DeliveryBoy {

    @Id @GeneratedValue private Long id;
    private String deliveryBoyId;
    private String deliveryBoyName;
    private Long mobile;
    private String status;
    private String location;

    public DeliveryBoy() {
    }

    @JsonIgnoreProperties("deliveryBoy")
    @Relationship(type = "PICKS_FROM", direction = Relationship.INCOMING)
    private List<Restaurant> restaurants;

    @Relationship(type = "LINKED_TO", direction = Relationship.INCOMING)
    private List<PropertiesRD> propertiesRD;

    @JsonIgnoreProperties("deliveryBoy")
    @Relationship(type = "DELIVERS_TO", direction = Relationship.OUTGOING)
    private List<Charity> charities;

    @Relationship(type = "LINKED_TO", direction = Relationship.OUTGOING)
    private List<PropertiesDC> propertiesDC;

    public DeliveryBoy(Long id, String deliveryBoyId, String deliveryBoyName, Long mobile, String status, String location, List<Restaurant> restaurants, List<Charity> charities) {
        this.id = id;
        this.deliveryBoyId = deliveryBoyId;
        this.deliveryBoyName = deliveryBoyName;
        this.mobile = mobile;
        this.status = status;
        this.location = location;
        this.restaurants = restaurants;
        this.charities = charities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeliveryBoyId() {
        return deliveryBoyId;
    }

    public void setDeliveryBoyId(String deliveryBoyId) {
        this.deliveryBoyId = deliveryBoyId;
    }

    public String getDeliveryBoyName() {
        return deliveryBoyName;
    }

    public void setDeliveryBoyName(String deliveryBoyName) {
        this.deliveryBoyName = deliveryBoyName;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Charity> getCharities() {
        return charities;
    }

    public void setCharities(List<Charity> charities) {
        this.charities = charities;
    }

}
