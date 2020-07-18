package com.stackroute.rabbitmq.model;

import com.stackroute.domain.Charity;
import com.stackroute.domain.Restaurant;
import lombok.Data;

import java.util.List;

@Data
public class DeliveryBoyStatus {

    private String username;
    private String deliveryBoyName;
    private String location;
    private List<Restaurant> restaurants;
    private Charity charity;

    public DeliveryBoyStatus() {
    }

    public DeliveryBoyStatus(String username, String deliveryBoyName, String location, List<Restaurant> restaurants, Charity charitiy) {
        this.username = username;
        this.deliveryBoyName = deliveryBoyName;
        this.location = location;
        this.restaurants = restaurants;
        this.charity = charity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDeliveryBoyName() {
        return deliveryBoyName;
    }

    public void setDeliveryBoyName(String deliveryBoyName) {
        this.deliveryBoyName = deliveryBoyName;
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

    public Charity getCharity() {
        return charity;
    }

    public void setCharity(Charity charity) {
        this.charity = charity;
    }
}
