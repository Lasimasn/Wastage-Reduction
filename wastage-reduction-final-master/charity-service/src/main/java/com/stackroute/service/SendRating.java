package com.stackroute.service;

import com.stackroute.rabbitmq.model.RatedRestaurant;
import com.stackroute.rabbitmq.model.RatedRestaurantsWrapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendRating {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${rating.rabbitmq.exchange}")
    private String ratingExchange;

    @Value("${rating.rabbitmq.routingkey}")
    private String ratingRoutingkey;



    public void sendToRestaurantLogs(List<RatedRestaurant> ratedRestaurants){
        System.out.println("Sent Rating: " +ratedRestaurants);
        RatedRestaurantsWrapper ratedRestaurantsWrapper = new RatedRestaurantsWrapper(ratedRestaurants);
        rabbitTemplate.convertAndSend(ratingExchange,ratingRoutingkey,ratedRestaurantsWrapper);
    }
}
