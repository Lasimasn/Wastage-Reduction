package com.stackroute.repository;

import com.stackroute.domain.DeliveryBoyLiveStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryBoyLiveStatusRepository extends MongoRepository<DeliveryBoyLiveStatus,String> {
}
