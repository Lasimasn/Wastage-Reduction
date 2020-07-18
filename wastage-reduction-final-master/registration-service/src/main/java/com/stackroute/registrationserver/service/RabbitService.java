package com.stackroute.registrationserver.service;

import com.stackroute.rabbitmq.model.CharityMQ;
import com.stackroute.rabbitmq.model.DeliveryBoyMQ;
import com.stackroute.rabbitmq.model.RestaurantMQ;
import com.stackroute.registrationserver.domain.Charities;
import com.stackroute.registrationserver.domain.DeliveryBoys;
import com.stackroute.registrationserver.domain.Restaurants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${restaurant.exchange}")
    private String restaurantExchange;

    @Value("${restaurant.routingkey}")
    private String restaurantRoutingkey;

    @Value("${restaurant.update.routingkey}")
    private String restaurantUpdateRoutingkey;

    @Value("${charity.exchange}")
    private String charityExchange;

    @Value("${charity.routingkey}")
    private String charityRoutingkey;

    @Value("${charity.update.routingkey}")
    private String charityUpdateRoutingkey;

    @Value("${deliveryBoy.exchange}")
    private String deliveryBoyExchange;

    @Value("${deliveryBoy.routingkey}")
    private String deliveryBoyRoutingkey;

    @Value("${deliveryBoy.update.routingkey}")
    private String deliveryBoyUpdateRoutingkey;

    public void sendToRestaurantRabbitMq(Restaurants restaurants) {

        RestaurantMQ restaurant = new RestaurantMQ(restaurants.getUsername(),restaurants.getPassword(),restaurants.getEmail(),restaurants.getRole(),restaurants.getName(),restaurants.getMobile(),restaurants.getAddress(),restaurants.getLocation(),restaurants.getCertificateNo(),restaurants.getCertificateName());

        rabbitTemplate.convertAndSend(restaurantExchange, restaurantRoutingkey,restaurant);

        System.out.println("Send msg = " + restaurant);

    }

    public void sendToCharityRabbitMq(Charities charities) {

        CharityMQ charity = new CharityMQ(charities.getUsername(),charities.getPassword(),charities.getEmail(), charities.getRole(),charities.getName(),charities.getMobile(),charities.getAddress(),charities.getLocation(),charities.getFoodRequirement(),charities.getCertificateNo(),charities.getCertificateName());

        rabbitTemplate.convertAndSend(charityExchange, charityRoutingkey,charity);

        System.out.println("Send msg = " + charity);

    }

    public void sendToDeliveryBoyMQ(DeliveryBoys deliveryBoys) {

        DeliveryBoyMQ deliveryBoyMQ = new DeliveryBoyMQ(deliveryBoys.getUsername(), deliveryBoys.getPassword(),deliveryBoys.getEmail(),deliveryBoys.getRole(),deliveryBoys.getName(),deliveryBoys.getMobile(),deliveryBoys.getAddress(),deliveryBoys.getLicenseNo(),deliveryBoys.getLicenseName());
        rabbitTemplate.convertAndSend(deliveryBoyExchange, deliveryBoyRoutingkey, deliveryBoyMQ);

        System.out.println("Sent CharityMQ = " + deliveryBoyMQ);

    }

    public void sendToRestaurantUpdateRabbitMq(Restaurants restaurants) {

        RestaurantMQ restaurant = new RestaurantMQ(restaurants.getUsername(),restaurants.getPassword(),restaurants.getEmail(),restaurants.getRole(),restaurants.getName(),restaurants.getMobile(),restaurants.getAddress(),restaurants.getLocation(),restaurants.getCertificateNo(),restaurants.getCertificateName());

        rabbitTemplate.convertAndSend(restaurantExchange, restaurantUpdateRoutingkey,restaurant);

        System.out.println("Send msg = " + restaurant);

    }

    public void sendToCharityUpdateRabbitMq(Charities charities) {

        CharityMQ charity = new CharityMQ(charities.getUsername(),charities.getPassword(),charities.getEmail(), charities.getRole(),charities.getName(),charities.getMobile(),charities.getAddress(),charities.getLocation(),charities.getFoodRequirement(),charities.getCertificateNo(),charities.getCertificateName());

        rabbitTemplate.convertAndSend(charityExchange, charityUpdateRoutingkey,charity);

        System.out.println("Send msg = " + charity);

    }

    public void sendToDeliveryBoyUpdateMQ(DeliveryBoys deliveryBoys) {

        DeliveryBoyMQ deliveryBoyMQ = new DeliveryBoyMQ(deliveryBoys.getUsername(), deliveryBoys.getPassword(),deliveryBoys.getEmail(),deliveryBoys.getRole(),deliveryBoys.getName(),deliveryBoys.getMobile(),deliveryBoys.getAddress(),deliveryBoys.getLicenseNo(),deliveryBoys.getLicenseName());
        rabbitTemplate.convertAndSend(deliveryBoyExchange, deliveryBoyUpdateRoutingkey, deliveryBoyMQ);

        System.out.println("Sent CharityMQ = " + deliveryBoyMQ);

    }


}