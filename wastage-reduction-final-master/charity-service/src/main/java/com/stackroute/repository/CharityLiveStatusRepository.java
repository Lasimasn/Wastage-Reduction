package com.stackroute.repository;

import com.stackroute.domain.CharityLiveStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharityLiveStatusRepository extends MongoRepository<CharityLiveStatus,String> {
}
