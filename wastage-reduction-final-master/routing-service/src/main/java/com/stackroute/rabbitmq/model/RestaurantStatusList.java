package com.stackroute.rabbitmq.model;

import lombok.Data;

import java.util.List;

@Data
public class RestaurantStatusList {

    private List<RestaurantStatus> restaurantStatusList;

    public RestaurantStatusList() {
    }

    public RestaurantStatusList(List<RestaurantStatus> restaurantStatusList) {
        this.restaurantStatusList = restaurantStatusList;
    }

    public List<RestaurantStatus> getRestaurantStatusList() {
        return restaurantStatusList;
    }

    public void setRestaurantStatusList(List<RestaurantStatus> restaurantStatusList) {
        this.restaurantStatusList = restaurantStatusList;
    }
}
