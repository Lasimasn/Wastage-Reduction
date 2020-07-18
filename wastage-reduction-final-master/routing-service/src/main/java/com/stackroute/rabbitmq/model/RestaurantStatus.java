package com.stackroute.rabbitmq.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
public class RestaurantStatus {

    @Id
    private String username;
    private String foodAvailability;
    private String deliveryBoyName;
    private Long mobile;

    public RestaurantStatus() {
    }

    public RestaurantStatus(String username, String foodAvailability, String deliveryBoyName, Long mobile) {
        this.username = username;
        this.foodAvailability = foodAvailability;
        this.deliveryBoyName = deliveryBoyName;
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFoodAvailability() {
        return foodAvailability;
    }

    public void setFoodAvailability(String foodAvailability) {
        this.foodAvailability = foodAvailability;
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
}
