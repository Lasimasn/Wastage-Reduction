package com.stackroute.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
public class RatedRestaurantsWrapper {
    public RatedRestaurantsWrapper(List<RatedRestaurant> ratedRestaurants) {
        this.ratedRestaurants = ratedRestaurants;
    }

    public List<RatedRestaurant> ratedRestaurants;

}
