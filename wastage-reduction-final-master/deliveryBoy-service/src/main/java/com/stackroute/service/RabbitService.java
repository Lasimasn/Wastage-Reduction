package com.stackroute.service;

import com.stackroute.domain.*;
import com.stackroute.rabbitmq.model.DeliveryBoyList;
import com.stackroute.rabbitmq.model.DeliveryBoyStatus;
import com.stackroute.repository.DeliveryBoyLiveStatusRepository;
import com.stackroute.repository.DeliveryBoyRepository;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RabbitListener(queues = "${deliveryBoyLogs.rabbitmq.queue}")
public class RabbitService {

    @Autowired
    private DeliveryBoyRepository deliveryBoyRepository;

    @Autowired
    private DeliveryBoyLiveStatusRepository deliveryBoyLiveStatusRepository;

    @RabbitHandler
    public void receivedmsg(DeliveryBoyList deliveryBoyListWrapper) {
        System.out.println(deliveryBoyListWrapper);
        List<DeliveryBoyStatus> deliveryBoys = deliveryBoyListWrapper.getDeliveryBoys();
        System.out.println("Recieved List :" + deliveryBoys);
        for (int i = 0; i < deliveryBoys.size(); i++) {
            DeliveryBoyStatus deliveryBoyStatus = deliveryBoys.get(i);
            System.out.println("Recieved Message For DeliveryBoy : " + deliveryBoyStatus.getDeliveryBoyName() + " => " + deliveryBoyStatus);
//            System.out.println(charityRepository.findById(charityStatus.getUsername()).get());
            DeliveryBoy deliveryBoy = new DeliveryBoy();
            try{
                deliveryBoy = deliveryBoyRepository.findById(deliveryBoyStatus.getUsername()).get();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            List<Logs> logsList = new ArrayList<>();
            if(deliveryBoy.getUsername()!=null) {
                logsList = deliveryBoy.getLogs();
            }
            Logs logs = new Logs();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            deliveryBoy.setUsername(deliveryBoyStatus.getUsername());
            logs.setId("1");
            logs.setDate(dtf.format(now));
            List<Restaurant> receivedRestaurants = deliveryBoyStatus.getRestaurants();
            List<RestaurantSave> restaurants = new ArrayList<>();
            for ( int k =0; k <receivedRestaurants.size(); k++ ) {
                Restaurant receivedRestaurant = receivedRestaurants.get(k);
                RestaurantSave restaurantSave = new RestaurantSave();
                restaurantSave.setUsername(receivedRestaurant.getRestaurantId());
                restaurantSave.setRestaurantName(receivedRestaurant.getRestaurantName());
                restaurantSave.setFoodAvailability(receivedRestaurant.getFoodAvailability());
                restaurantSave.setLocation(receivedRestaurant.getLocation());
                System.out.println("check in loop ===" + restaurantSave);
                restaurants.add(restaurantSave);
            }
            Charity receivedCharity = deliveryBoyStatus.getCharity();
            List<CharitySave> charities = new ArrayList<>();
            for (int j = 0; j < 1; j++){
//                  Charity receivedCharity = receivedCharityList.get(j);
                CharitySave charitySave = new CharitySave();
                if(receivedCharity!=null) {
                    charitySave.setUsername(receivedCharity.getCharityId());
                    charitySave.setCharityName(receivedCharity.getCharityName());
                    charitySave.setFoodReceived(receivedCharity.getFoodAvailable());
                    charitySave.setLocation(receivedCharity.getLocation());
                }
                charities.add(charitySave);
            }
            System.out.println("check -- " + restaurants);
            logs.setRestaurants(restaurants);
            logs.setCharities(charities);
            logsList.add(logs);
            deliveryBoy.setLogs(logsList);
            deliveryBoyRepository.save(deliveryBoy);
            DeliveryBoyLiveStatus deliveryBoyLiveStatus = new DeliveryBoyLiveStatus(deliveryBoyStatus.getUsername(),logs);
            deliveryBoyLiveStatusRepository.save(deliveryBoyLiveStatus);
        }
    }
}

