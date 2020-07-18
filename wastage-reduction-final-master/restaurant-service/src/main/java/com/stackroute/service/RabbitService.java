package com.stackroute.service;
import com.stackroute.domain.Restaurant;
import com.stackroute.domain.Logs;
import com.stackroute.domain.RestaurantLiveStatus;
import com.stackroute.domain.SequenceGenerator;
import com.stackroute.rabbitmq.model.RestaurantStatus;
import com.stackroute.rabbitmq.model.RestaurantStatusList;
import com.stackroute.repository.RestaurantLiveStatusRepository;
import com.stackroute.repository.RestaurantRepository;
import com.stackroute.repository.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Component
@RabbitListener(queues = "${restaurantLogs.rabbitmq.queue}")
public class RabbitService {

     @Autowired
     RestaurantRepository restaurantRepository;

     @Autowired
    RestaurantLiveStatusRepository restaurantLiveStatusRepository;

    @Autowired
    SequenceRepository sequenceRepository;

    @RabbitHandler
    public void recievedMessage(RestaurantStatusList restaurantStatusListWrapper) {
        List<RestaurantStatus> restaurantStatusList = restaurantStatusListWrapper.getRestaurantStatusList();
        System.out.println(restaurantStatusList);
        for (int i = 0; i < restaurantStatusList.size(); i++) {
            RestaurantStatus restaurantStatus = restaurantStatusList.get(i);
            System.out.println(restaurantStatus+"--------");
            System.out.println("Recieved Message For Restaurant : " + restaurantStatus.getUsername() + " => " + restaurantStatus);
            Restaurant restaurant;
            List<Logs> logsList;
            SequenceGenerator sequenceGenerator = new SequenceGenerator("",0);
            try{
                restaurant = restaurantRepository.findById(restaurantStatus.getUsername()).get();
                logsList = restaurant.getLogs();
                sequenceGenerator = sequenceRepository.findById(restaurantStatus.getUsername()).get();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                logsList = new ArrayList<>();
            }
            System.out.println(restaurantStatus);
            Logs logs = new Logs();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            logs.setId(sequenceGenerator.getCount());
            sequenceGenerator.setUsername(restaurantStatus.getUsername());
            sequenceGenerator.setCount(sequenceGenerator.getCount()+1);
            sequenceRepository.save(sequenceGenerator);
            logs.setDate(dtf.format(now));
            logs.setRating(0);
            logs.setRestaurantStatus(restaurantStatus);
            logsList.add(logs);
            restaurant = new Restaurant(restaurantStatus.getUsername(),logsList);
//            restaurantRepository.save(restaurant);
            RestaurantLiveStatus restaurantLiveStatus = new RestaurantLiveStatus(restaurant.getUserName(),logs);
            restaurantLiveStatusRepository.save(restaurantLiveStatus);
    }
}
}
