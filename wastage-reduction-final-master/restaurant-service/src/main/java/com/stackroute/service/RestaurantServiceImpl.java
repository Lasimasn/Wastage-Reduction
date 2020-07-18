package com.stackroute.service;
import com.stackroute.domain.Logs;
import com.stackroute.domain.Restaurant;
import com.stackroute.domain.RestaurantLiveStatus;
import com.stackroute.domain.SequenceGenerator;
import com.stackroute.repository.RestaurantLiveStatusRepository;
import com.stackroute.repository.RestaurantRepository;
import com.stackroute.repository.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    RestaurantLiveStatusRepository restaurantLiveStatusRepository;


    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant saveRestaurantLog(String username) {
        Restaurant restaurant;
        List<Logs> logsList;

        try{
            restaurant = restaurantRepository.findById(username).get();
            logsList = restaurant.getLogs();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            logsList = new ArrayList<>();
        }
            RestaurantLiveStatus restaurantLiveStatus = restaurantLiveStatusRepository.findById(username).get();
            Logs logs = restaurantLiveStatus.getLogs();
            logsList.add(logs);
            restaurant = new Restaurant(username,logsList);
            return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurantLog() throws Exception {
        List<Restaurant> log = restaurantRepository.findAll();
        return log;
    }
    @Override
    public Restaurant fetchRestaurantLogs(String username)
    {
        return restaurantRepository.findById(username).get();
    }

    @Override
    public RestaurantLiveStatus fetchRestaurantLiveStatus(String username) {
        return restaurantLiveStatusRepository.findById(username).get();
    }

    //    @Override
//    public Restaurant getRestaurantByName(String username) {
//        return restaurantLogRepository.getRestaurantByName(username);
//    }
//


    //@Override
//public RestaurantLogs saveRestaurantLog(RestaurantLogs restaurantLogs) throws RestaurantIdAlreadyExistsException{
//    if(restaurantLogRepository.existsById(restaurantLogs.getRestaurantlogid()))
    {
//        throw new RestaurantIdAlreadyExistsException("RestaurantID already exists exception");
//    }
//    RestaurantLogs savedrestaurantLog =restaurantLogRepository.save(restaurantLogs);
//    if(savedrestaurantLog ==null)
//    {
//        throw new RestaurantIdAlreadyExistsException("RestaurantID already exist exception");
//    }
//
//    return savedrestaurantLog;
//}

//    @Override
//    public List<Restaurant> getAllRestaurantLog() throws Exception {
//
//        List<Restaurant> log = restaurantLogRepository.findAll();
//        return log;
//    }
//
//    @Override
//    public boolean deleteRestaurantLog(String restaurantName) throws Exception {
//        boolean status=false;
//        if(restaurantLogRepository.existsById(restaurantName))
//        {
//            restaurantLogRepository.deleteById(restaurantName);
//            status=true;
//            return status;
//        }
//        else{
//            throw new Exception("Restaurant not found");
//        }
//    }


//    @Override
//    public List<RestaurantLogs> getRestaurantByName(String restaurantName) throws RestaurantNameNotFoundException {
//        List<RestaurantLogs> listOfRestaurants = null;
//        listOfRestaurants= restaurantLogRepository.getRestaurantByName(restaurantName);
//        if (listOfRestaurants.isEmpty())
//        {
//            throw new RestaurantNameNotFoundException("Restaurant Name Not Found");
//        }
//        return listOfRestaurants;
//    }
    }
}