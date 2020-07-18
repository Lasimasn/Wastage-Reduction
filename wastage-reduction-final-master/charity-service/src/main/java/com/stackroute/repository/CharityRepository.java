package com.stackroute.repository;

import com.stackroute.domain.Charity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CharityRepository extends MongoRepository<Charity,String> {
    public Charity findByUsername(String username);
}
