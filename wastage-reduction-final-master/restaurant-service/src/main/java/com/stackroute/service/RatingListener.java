package com.stackroute.service;

import com.stackroute.domain.Logs;
import com.stackroute.domain.Restaurant;
import com.stackroute.rabbitmq.model.RatedRestaurant;
import com.stackroute.rabbitmq.model.RatedRestaurantsWrapper;
import com.stackroute.repository.RestaurantRepository;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@RabbitListener (queues = "${rating.rabbitmq.queue}")
public class RatingListener {

    @Autowired
    RestaurantRepository restaurantRepository;

    @RabbitHandler
    public void fetchRatedRestaurants(RatedRestaurantsWrapper ratedRestaurantsWrapper){
        List<RatedRestaurant> ratedRestaurants = ratedRestaurantsWrapper.getRatedRestaurants();
        System.out.println("Received Rating: " + ratedRestaurants);
        for (int i = 0; i < ratedRestaurants.size(); i++){
            RatedRestaurant ratedRestaurant = ratedRestaurants.get(i);
            Restaurant restaurant = restaurantRepository.findById(ratedRestaurant.getUsername()).get();
            List<Logs> logsList = restaurant.getLogs();
            for (int j = 0; j < logsList.size(); j++){
                Logs logs = logsList.get(j);
                if(logs.getId()==ratedRestaurant.getLogId()){
                    logs.setRating(ratedRestaurant.getRating());
                }
                logsList.set(j,logs);
            }
            restaurant.setLogs(logsList);
            restaurantRepository.save(restaurant);
        }
    }
}