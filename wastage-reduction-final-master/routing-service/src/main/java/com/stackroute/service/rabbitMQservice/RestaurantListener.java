package com.stackroute.service.rabbitMQservice;


import com.stackroute.domain.Charity;
import com.stackroute.domain.DeliveryBoy;
import com.stackroute.domain.Restaurant;
import com.stackroute.rabbitmq.model.RestaurantMQ;
import com.stackroute.repository.CharityRepository;
import com.stackroute.repository.DeliveryBoyRepository;
import com.stackroute.repository.RestaurantRepository;
import com.stackroute.seedData.FoodAvailabilityData;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RabbitListener(queues = "${restaurant.update.queue}")
public class RestaurantListener {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CharityRepository charityRepository;

    @Autowired
    private DeliveryBoyRepository deliveryBoyRepository;

    @RabbitHandler
    @Transactional
    public void recievedAndSaved(RestaurantMQ restaurantMQ) {
        FoodAvailabilityData foodAvailabilityData = new FoodAvailabilityData();
        String foodAvailibility = foodAvailabilityData.onDataReceived(restaurantMQ.getUsername());
        Restaurant restaurant = new Restaurant(restaurantMQ.getUsername(), restaurantMQ.getRestaurantName(), foodAvailibility, restaurantMQ.getLocation(), "no");
        try {
            if (restaurantRepository.findByRestaurantId(restaurant.getRestaurantId()) == null) {
                System.out.println(restaurantRepository.saveRestaurant(restaurant.getRestaurantId(), restaurant.getRestaurantName(), restaurant.getLocation(), restaurant.getFoodAvailability(), restaurant.getDonated()));
                String[] restaurantLocation = restaurant.getLocation().split(",");
                double restaurantLat = Double.parseDouble(restaurantLocation[0]);
                double restaurantLon = Double.parseDouble(restaurantLocation[1]);
                List<Charity> charityList = charityRepository.fetchCharities();
                for (int i = 0; i < charityList.size(); i++) {
                    Charity charity = charityList.get(i);
                    String[] charityLocation = charity.getLocation().split(",");
                    double charityLat = Double.parseDouble(charityLocation[0]);
                    double charityLon = Double.parseDouble(charityLocation[1]);
                    double distance = getDistanceFromLatLonInKm(restaurantLat, restaurantLon, charityLat, charityLon);
//                    charityRepository.createRestaurantCharityRelation(restaurant.getRestaurantId(), charity.getCharityId(), distance, "no");
                }
                List<DeliveryBoy> deliveryBoyList = deliveryBoyRepository.fetchDeliveryBoys();
                for (int j = 0; j < deliveryBoyList.size(); j++) {
                    DeliveryBoy deliveryBoy = deliveryBoyList.get(j);
                    String[] deliveryBoyLocation = deliveryBoy.getLocation().split(",");
                    double deliveryBoyLat = Double.parseDouble(deliveryBoyLocation[0]);
                    double deliveryBoyLon = Double.parseDouble(deliveryBoyLocation[1]);
                    double distance = getDistanceFromLatLonInKm(restaurantLat, restaurantLon, deliveryBoyLat, deliveryBoyLon);
//                    deliveryBoyRepository.createRestaurantDeliveryBoyRelation(restaurant.getRestaurantId(), deliveryBoy.getDeliveryBoyId(), distance);

                }
            }
            else
                System.out.println(restaurantRepository.updateRestaurant(restaurant.getRestaurantId(),restaurant.getRestaurantName(),restaurant.getLocation(),restaurant.getFoodAvailability(),restaurant.getDonated()));
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
