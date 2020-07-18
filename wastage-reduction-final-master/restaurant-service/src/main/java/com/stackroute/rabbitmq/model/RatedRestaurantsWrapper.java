package com.stackroute.rabbitmq.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
public class RatedRestaurantsWrapper {

    public List<RatedRestaurant> ratedRestaurants;

    public RatedRestaurantsWrapper(List<RatedRestaurant> ratedRestaurants) {
        this.ratedRestaurants = ratedRestaurants;
    }

    public List<RatedRestaurant> getRatedRestaurants() {
        return ratedRestaurants;
    }

    public void setRatedRestaurants(List<RatedRestaurant> ratedRestaurants) {
        this.ratedRestaurants = ratedRestaurants;
    }
}
