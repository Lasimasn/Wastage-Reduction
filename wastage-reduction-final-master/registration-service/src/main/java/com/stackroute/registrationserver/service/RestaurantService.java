package com.stackroute.registrationserver.service;

import com.stackroute.registrationserver.domain.RestaurantProfile;
import com.stackroute.registrationserver.domain.Restaurants;
import com.stackroute.registrationserver.exceptions.EntityAlreadyExistsException;
import com.stackroute.registrationserver.exceptions.EntityNotExistsException;

import java.util.List;

public interface RestaurantService {

    RestaurantProfile saveRestaurant(Restaurants restaurant) throws EntityAlreadyExistsException;
    List<RestaurantProfile> displayRestaurants() throws Exception;
    RestaurantProfile updateRestaurant(Restaurants restaurants)throws EntityNotExistsException;
    RestaurantProfile displayRestaurantByUsername(String username) throws  EntityNotExistsException;
}