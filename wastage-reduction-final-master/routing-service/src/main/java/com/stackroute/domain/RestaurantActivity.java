package com.stackroute.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestaurantActivity {
    private String restaurantId;
    private String foodAvailability;

    public RestaurantActivity() {
    }

    public RestaurantActivity(String restaurantId, String foodAvailability) {
        this.restaurantId = restaurantId;
        this.foodAvailability = foodAvailability;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getFoodAvailability() {
        return foodAvailability;
    }

    public void setFoodAvailability(String foodAvailability) {
        this.foodAvailability = foodAvailability;
    }
}
