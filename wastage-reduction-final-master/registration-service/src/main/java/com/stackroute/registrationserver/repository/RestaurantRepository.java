package com.stackroute.registrationserver.repository;

import com.stackroute.registrationserver.domain.RestaurantProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantProfile, String> {
    @Query(value = "SELECT * FROM restaurant_profile WHERE username = ?1", nativeQuery = true)
    public RestaurantProfile displayRestaurantByUsername(String username);
}
