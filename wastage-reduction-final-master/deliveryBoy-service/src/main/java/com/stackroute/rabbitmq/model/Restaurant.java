package com.stackroute.rabbitmq.model;

import lombok.Data;

@Data
public class Restaurant {
    private String restaurantId;
    private String restaurantName;
    private String foodAvailability;
    private String location;
    private String donated;

    public Restaurant()
    {

    }

    public Restaurant(String restaurantId, String restaurantName, String foodAvailability, String location, String donated) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.foodAvailability = foodAvailability;
        this.location = location;
        this.donated = donated;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getFoodAvailability() {
        return foodAvailability;
    }

    public void setFoodAvailability(String foodAvailability) {
        this.foodAvailability = foodAvailability;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDonated() {
        return donated;
    }

    public void setDonated(String donated) {
        this.donated = donated;
    }
}
