package com.stackroute.service;

import com.stackroute.domain.Restaurant;
//import com.stackroute.restaurant.restaurantlogserver.exceptions.RestaurantIdAlreadyExistsException;
//import com.stackroute.restaurant.restaurantlogserver.exceptions.RestaurantNameNotFoundException;
import com.stackroute.domain.RestaurantLiveStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantService {
    Restaurant saveRestaurantLog(String username);

    List<Restaurant> getAllRestaurantLog() throws Exception;

    Restaurant fetchRestaurantLogs(String username);

    RestaurantLiveStatus fetchRestaurantLiveStatus(String username);


}
