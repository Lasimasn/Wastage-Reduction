package com.stackroute.repository;

import com.stackroute.domain.SequenceGenerator;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceRepository extends MongoRepository<SequenceGenerator,String> {
}
