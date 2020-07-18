//package com.stackroute.restaurant.restaurantlogserver.repository;
//
//import RestaurantLogs;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@DataMongoTest
//public class RestaurantLogRepositoryTest {
//    @Autowired
//    private RestaurantLogRepository restaurantLogRepository;
//
//    private RestaurantLogs restaurantLogs;
//
//    @Test
//    public void testgetAllRestaurantLog(){
////        restaurantLogRepository.save(restaurantLogs);
//        List<RestaurantLogs> list = restaurantLogRepository.findAll();
//        System.out.println(list.get(0));
//        Assert.assertEquals(2334,list.get(0).getRestaurantlogid());
//
//    }
//}