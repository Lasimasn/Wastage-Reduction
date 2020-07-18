package com.stackroute.repository;

import com.stackroute.domain.Restaurant;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "restaurants", path = "restaurants")

public interface RestaurantRepository extends Neo4jRepository<Restaurant, Long> {


    @Query("CREATE (r:Restaurant { restaurantId : {restaurantId}, restaurantName : {restaurantName}, foodAvailability : {foodAvailability},location : {location}, donated : {donated} }) RETURN r")
    public Restaurant saveRestaurant(@Param("restaurantId") String restaurantId, @Param("restaurantName") String restaurantName,@Param("location") String location, @Param("foodAvailability") String foodAvailability, @Param("donated") String donated);


    @Query("MATCH (c:Restaurant) RETURN c")
    public List<Restaurant> fetchRestaurants();


    @Query("MATCH (r:Restaurant) WHERE  r.restaurantId = {restaurantId} SET r.restaurantName = {restaurantName}, r.foodAvailability = {foodAvailability}, r.location = {location}, r.donated = {donated} RETURN r")
    public Restaurant updateRestaurant(@Param("restaurantId") String restaurantId, @Param("restaurantName") String restaurantName,@Param("location") String location, @Param("foodAvailability") String foodAvailability, @Param("donated") String donated);


    @Query("MATCH (r:Restaurant) WHERE r.restaurantId = {restaurantId} SET r.foodAvailability = {foodAvailability}")
    public void updateRestaurantFoodAvailability(@Param("restaurantId") String restaurantId, @Param("foodAvailability") String foodAvailability);


    @Query("MATCH (r:Restaurant { restaurantId: {restaurantId} }) DETACH DELETE r")
    public void removeRestaurant(@Param("restaurantId") String restaurantId);


    @Query("MATCH (rs:Restaurant)-[r:DONATES_TO]->(c:Charity) WHERE c.charityId = {charityId} AND rs.donated = 'no' AND r.distance < 10.0 RETURN rs ORDER BY r.distance")
    public List<Restaurant> getSortedRestaurantsByDistanceAndAvailability(@Param("charityId") String charityId);


    @Query("MATCH (rs:Restaurant) WHERE rs.restaurantId = {restaurantId} SET rs.donated = {charityId}")
    public void updateDonatedStatus(@Param("restaurantId") String restaurantId, @Param("charityId") String charityId);


    @Query("MATCH (rs:Restaurant)-[r:DONATES_TO]->(c:Charity) WHERE rs.donated = {charityId}  RETURN rs ORDER BY rs.restaurantId")
    public List<Restaurant> getAllocatedRestaurants(@Param("charityId") String charityId);


    @Query("MATCH (rs:Restaurant) SET rs.donated = 'no'")
    public void resetDonated();

    @Query("MATCH (rs:Restaurant) WHERE rs.restaurantId = {restaurantId} RETURN rs")
    public Restaurant findByRestaurantId(@Param("restaurantId") String restaurantId);
}


