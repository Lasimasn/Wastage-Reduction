package com.stackroute.repository;
import com.stackroute.domain.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant,String>{
    @Query("{ 'userName' : ?0 },{}")
    Restaurant getRestaurantByName(String userName);
}
