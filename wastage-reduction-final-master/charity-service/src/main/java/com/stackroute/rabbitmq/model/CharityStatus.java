package com.stackroute.rabbitmq.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor
public class CharityStatus {

    @Id
    private String username;
    private String foodAvailable;
    private String deliveryBoyName;
    private Long mobile;
    private List<String> restaurantIds;

    public CharityStatus(String username, String foodAvailable, String deliveryBoyName, Long mobile, List<String> restaurantIds) {
        this.username = username;
        this.foodAvailable = foodAvailable;
        this.deliveryBoyName = deliveryBoyName;
        this.mobile = mobile;
        this.restaurantIds = restaurantIds;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFoodAvailable() {
        return foodAvailable;
    }

    public void setFoodAvailable(String foodAvailable) {
        this.foodAvailable = foodAvailable;
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

    public List<String> getRestaurantIds() {
        return restaurantIds;
    }

    public void setRestaurantIds(List<String> restaurantIds) {
        this.restaurantIds = restaurantIds;
    }
}
