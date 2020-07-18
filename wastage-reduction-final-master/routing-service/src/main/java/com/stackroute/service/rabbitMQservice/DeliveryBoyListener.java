package com.stackroute.service.rabbitMQservice;


import com.stackroute.domain.Charity;
import com.stackroute.domain.DeliveryBoy;
import com.stackroute.rabbitmq.model.DeliveryBoyMQ;
import com.stackroute.repository.CharityRepository;
import com.stackroute.repository.DeliveryBoyRepository;
import com.stackroute.repository.RestaurantRepository;
import com.stackroute.domain.Restaurant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RabbitListener(queues = "${deliveryBoy.update.queue}")
public class DeliveryBoyListener {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CharityRepository charityRepository;

    @Autowired
    private DeliveryBoyRepository deliveryBoyRepository;

    @RabbitHandler @Transactional
    public void recievedAndSaved(DeliveryBoyMQ deliveryBoyMQ) {
        double deliveryBoyLat = 12.971599;
        double deliveryBoyLon = 77.594566;
        try {
            if (deliveryBoyRepository.findByDeliveryBoyId(deliveryBoyMQ.getUsername()) == null) {
                System.out.println(deliveryBoyRepository.saveDeliveryBoy(deliveryBoyMQ.getUsername(),deliveryBoyMQ.getDeliveryBoyName(),deliveryBoyMQ.getMobile(),"available", deliveryBoyLat+ "," + deliveryBoyLon));
                List<Restaurant> restaurantList = restaurantRepository.fetchRestaurants();
                for (int i = 0; i < restaurantList.size(); i++) {
                    Restaurant restaurant = restaurantList.get(i);
                    String[] restaurantLocation = restaurant.getLocation().split(",");
                    double restaurantLat = Double.parseDouble(restaurantLocation[0]);
                    double restaurantLon = Double.parseDouble(restaurantLocation[1]);
                    double distance = getDistanceFromLatLonInKm(deliveryBoyLat,deliveryBoyLon,restaurantLat,restaurantLon);
//                    deliveryBoyRepository.createRestaurantDeliveryBoyRelation(restaurant.getRestaurantId(),deliveryBoyMQ.getUsername(),distance);
                }
                List<Charity> charityList = charityRepository.fetchCharities();
                for (int j = 0; j < charityList.size(); j++){
                    Charity charity = charityList.get(j);
                    String[] charityLocation = charity.getLocation().split(",");
                    double charityLat = Double.parseDouble(charityLocation[0]);
                    double charityLon = Double.parseDouble(charityLocation[1]);
                    double distance = getDistanceFromLatLonInKm(deliveryBoyLat,deliveryBoyLon,charityLat,charityLon);
//                    deliveryBoyRepository.createDeliveryBoyCharityRelation(deliveryBoyMQ.getUsername(),charity.getCharityId(),distance);

                }
            }
            else
                System.out.println(deliveryBoyRepository.updateDeliveryBoy(deliveryBoyMQ.getUsername(),deliveryBoyMQ.getDeliveryBoyName(),deliveryBoyMQ.getMobile(),"available", deliveryBoyLat+ "," + deliveryBoyLon));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    double getDistanceFromLatLonInKm(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371; // Radius of the earth in km
        double dLat = Math.toRadians(lat2 - lat1);  // conversion to radians
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c; // Distance in km
    }
}
