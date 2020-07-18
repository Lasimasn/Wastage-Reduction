package com.stackroute.repository;

import com.stackroute.domain.RestaurantLiveStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantLiveStatusRepository extends MongoRepository<RestaurantLiveStatus,String> {
}
