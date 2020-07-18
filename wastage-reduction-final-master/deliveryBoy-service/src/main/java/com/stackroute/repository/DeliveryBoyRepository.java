package com.stackroute.repository;

import com.stackroute.domain.DeliveryBoy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryBoyRepository extends MongoRepository<DeliveryBoy,String> {
    public DeliveryBoy findByUsername(String username);
}
