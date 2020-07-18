package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class RestaurantSave {
    private String username;
    private String restaurantName;
    private String foodAvailability;
    private String location;

    public RestaurantSave() {
    }

    public RestaurantSave(String username, String restaurantName, String foodAvailability, String location) {
        this.username = username;
        this.restaurantName = restaurantName;
        this.foodAvailability = foodAvailability;
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
