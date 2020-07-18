package com.stackroute.service.rabbitMQservice;

import com.stackroute.domain.Charity;
import com.stackroute.domain.DeliveryBoy;
import com.stackroute.domain.Restaurant;
import com.stackroute.rabbitmq.model.*;
import com.stackroute.repository.CharityRepository;
import com.stackroute.repository.DeliveryBoyRepository;
import com.stackroute.repository.RestaurantRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SendOutput {

    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Autowired
    public RestaurantRepository restaurantRepository;

    @Autowired
    public CharityRepository charityRepository;

    @Autowired
    public DeliveryBoyRepository deliveryBoyRepository;

    @Value("${restaurant.exchange}")
    private String restaurantExchange;

    @Value("${restaurantLogs.routingkey}")
    private String restaurantRoutingkey;

    @Value("${charity.exchange}")
    private String charityExchange;

    @Value("${charityLogs.routingkey}")
    private String charityRoutingkey;

    @Value("${deliveryBoy.exchange}")
    private String deliveryBoyExchange;

    @Value("${deliveryBoyLogs.routingkey}")
    private String deliveryBoyRoutingkey;

    public void sendToRestaurantLogs() {
        System.out.println("------------ Sending to Restaurant Logs ------------");
//        rabbitTemplate.convertAndSend(restaurantExchange, restaurantRoutingkey, deliveryBoys);
        List<RestaurantStatus> restaurantStatusList = new ArrayList<>();
        List<Restaurant> restaurantList = restaurantRepository.fetchRestaurants();
        for( int i =0; i < restaurantList.size(); i++){
            Restaurant restaurant = restaurantList.get(i);
            DeliveryBoy deliveryBoy;
            System.out.println(restaurant.getRestaurantId()+restaurant.getFoodAvailability());
            RestaurantStatus restaurantStatus = new RestaurantStatus(restaurant.getRestaurantId(),restaurant.getFoodAvailability(),"Not Alocated",Integer.toUnsignedLong(0));
            try {
                deliveryBoy = deliveryBoyRepository.fetchDeliveryBoysForRestaurant(restaurant.getRestaurantId());
                restaurantStatus = new RestaurantStatus(restaurant.getRestaurantId(), restaurant.getFoodAvailability(), deliveryBoy.getDeliveryBoyName(), deliveryBoy.getMobile());
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            restaurantStatusList.add(restaurantStatus);
        }
        System.out.println("Sent Logs : " + restaurantStatusList);
        RestaurantStatusList restaurantStatusListWrapper = new RestaurantStatusList(restaurantStatusList);
        rabbitTemplate.convertAndSend(restaurantExchange, restaurantRoutingkey, restaurantStatusListWrapper);
//        rabbitTemplate.convertAndSend(deliveryBoyExchange, deliveryBoyRoutingkey, deliveryBoys);
    }

    public void sendToCharityLogs() {
        System.out.println("------------ Sending to Charity Logs ------------");
        int foodAvailable=0;
        List<CharityStatus> charityStatusList = new ArrayList<CharityStatus>();
        List<Charity> charityList = charityRepository.fetchCharities();
        for( int i =0; i < charityList.size(); i++){
            Charity charity = charityList.get(i);
            DeliveryBoy deliveryBoy = new DeliveryBoy();
            List<Restaurant> restaurantList = restaurantRepository.getAllocatedRestaurants(charity.getCharityId());
            List<String> restaurantIds = new ArrayList<>();
            for ( int j = 0; j < restaurantList.size(); j++){
                Restaurant restaurant = restaurantList.get(j);
                restaurantIds.add(restaurant.getRestaurantId());
                foodAvailable = foodAvailable + Integer.parseInt(restaurant.getFoodAvailability());
            }
            CharityStatus charityStatus = new CharityStatus(charity.getCharityId(),Integer.toString(foodAvailable),"Not Allocated",Integer.toUnsignedLong(0),restaurantIds);
            try{
                deliveryBoy = deliveryBoyRepository.fetchDeliveryBoysForCharity(charity.getCharityId());
                charityStatus = new CharityStatus(charity.getCharityId(), Integer.toString(foodAvailable), deliveryBoy.getDeliveryBoyName(), deliveryBoy.getMobile(), restaurantIds);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            charityStatusList.add(charityStatus);
            foodAvailable=0;
        }
        System.out.println("Sent Logs : " + charityStatusList);
        CharityStatusList charityStatusListWrapper = new CharityStatusList(charityStatusList);
        rabbitTemplate.convertAndSend(charityExchange, charityRoutingkey, charityStatusListWrapper);
//        rabbitTemplate.convertAndSend(deliveryBoyExchange, deliveryBoyRoutingkey, deliveryBoys);
    }

    public void sendToDeliveryBoyLogs() {
        System.out.println("------------ Sending to Delivery Boy Logs ------------");
        List<DeliveryBoy> deliveryBoyList = deliveryBoyRepository.fetchDeliveryBoys();
        List<DeliveryBoyStatus> deliveryBoyStatusList = new ArrayList<>();
        for (int i = 0; i < deliveryBoyList.size(); i++){
            DeliveryBoy deliveryBoy = deliveryBoyList.get(i);
            List<Restaurant> restaurants = deliveryBoyRepository.fetchAssignedResturantsForDeliveryBoy(deliveryBoy.getDeliveryBoyId());
            Charity charity = deliveryBoyRepository.fetchAssignedCharityForDeliveryBoy(deliveryBoy.getDeliveryBoyId());
            DeliveryBoyStatus deliveryBoyStatus = new DeliveryBoyStatus(deliveryBoy.getDeliveryBoyId(),deliveryBoy.getDeliveryBoyName(),deliveryBoy.getLocation(),restaurants,charity);

            deliveryBoyStatus.setCharity(charity);
            System.out.println(deliveryBoyStatus);
            deliveryBoyStatusList.add(deliveryBoyStatus);
        }
        System.out.println( deliveryBoyStatusList);
        DeliveryBoyList deliveryBoyListWrapper = new DeliveryBoyList(deliveryBoyStatusList);
        System.out.println("Sent Logs : " + deliveryBoyListWrapper);
        rabbitTemplate.convertAndSend(deliveryBoyExchange,deliveryBoyRoutingkey,deliveryBoyListWrapper);
    }
}