package com.stackroute.authenticationserver.service;

import com.stackroute.authenticationserver.model.User;
import com.stackroute.rabbitmq.model.CharityMQ;
import com.stackroute.rabbitmq.model.DeliveryBoyMQ;
import com.stackroute.rabbitmq.model.RestaurantMQ;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "${restaurant.queue}")
@RabbitListener(queues = "${charity.queue}")
@RabbitListener(queues = "${deliveryBoy.queue}")
public class RestaurantRabbitService {


    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RabbitHandler
    public void recievedRestaurantMessage(RestaurantMQ restaurant) throws Exception{
        System.out.println("Recieved RestaurantMQ Message From RabbitMQ: " + restaurant);
        User user = new User(restaurant.getUsername(),restaurant.getPassword(), restaurant.getRole());
        userDetailsService.save(user);

    }

    @RabbitHandler
    public void recievedCharityMessage(CharityMQ charity) throws Exception{
        System.out.println("Recieved Message From RabbitMQ: " + charity);
        User user = new User(charity.getUsername(),charity.getPassword(), charity.getRole());
        userDetailsService.save(user);

    }

    @RabbitHandler
    public void recieveddeliveryBoyMessage(DeliveryBoyMQ deliveryBoy) throws Exception{
        System.out.println("Recieved Message From RabbitMQ: " + deliveryBoy);
        User user = new User(deliveryBoy.getUsername(),deliveryBoy.getPassword(), deliveryBoy.getRole());
        userDetailsService.save(user);

    }
}