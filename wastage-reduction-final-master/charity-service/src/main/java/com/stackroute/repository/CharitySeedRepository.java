package com.stackroute.repository;

import com.stackroute.domain.CharitySeed;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface CharitySeedRepository extends MongoRepository<CharitySeed, String> {

}
