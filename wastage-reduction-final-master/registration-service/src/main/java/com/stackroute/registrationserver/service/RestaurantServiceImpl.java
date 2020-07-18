package com.stackroute.registrationserver.service;

import com.stackroute.registrationserver.domain.Restaurants;
import com.stackroute.registrationserver.domain.RestaurantProfile;
import com.stackroute.registrationserver.exceptions.EntityAlreadyExistsException;
import com.stackroute.registrationserver.exceptions.EntityNotExistsException;
import com.stackroute.registrationserver.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {


    RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository){

        this.restaurantRepository = restaurantRepository;

    }

    @Override
    public RestaurantProfile saveRestaurant(Restaurants restaurant) throws EntityAlreadyExistsException {

        if(restaurantRepository.existsById(restaurant.getUsername()))
        {
            throw new EntityAlreadyExistsException("Restaurant Already Exists");
        }
        else {
            RestaurantProfile restaurantProfile = new RestaurantProfile(restaurant.getUsername(), restaurant.getEmail(), restaurant.getRole(), restaurant.getName(), restaurant.getMobile(), restaurant.getAddress(), restaurant.getLocation(), restaurant.getCertificateNo(), restaurant.getCertificateName());
            RestaurantProfile savedRestaurantDetails = restaurantRepository.save(restaurantProfile);
            return savedRestaurantDetails;
        }
    }

    @Override
    public List<RestaurantProfile> displayRestaurants() throws Exception {
        return restaurantRepository.findAll();
    }

    @Override
    public RestaurantProfile displayRestaurantByUsername(String username) throws EntityNotExistsException {
        if(restaurantRepository.existsById(username)) {
            RestaurantProfile restaurant = restaurantRepository.displayRestaurantByUsername(username);
            return restaurant;
        }
        else {
            throw new EntityNotExistsException("Restaurant Not Exists");
        }
    }

    @Override
    public RestaurantProfile updateRestaurant(Restaurants restaurant) throws EntityNotExistsException {
        if(!restaurantRepository.existsById(restaurant.getUsername()))
        {
            throw new EntityNotExistsException("Restaurant Not Exists");
        }
        else {
            RestaurantProfile restaurantProfile = new RestaurantProfile(restaurant.getUsername(), restaurant.getEmail(), restaurant.getRole(), restaurant.getName(), restaurant.getMobile(), restaurant.getAddress(), restaurant.getLocation(), restaurant.getCertificateNo(), restaurant.getCertificateName());
            return restaurantRepository.save(restaurantProfile);
        }
    }
}
