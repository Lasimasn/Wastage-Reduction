package com.stackroute.repository;

import com.stackroute.domain.Charity;
import com.stackroute.domain.DeliveryBoy;
import com.stackroute.domain.Restaurant;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeliveryBoyRepository extends Neo4jRepository<DeliveryBoy, Long> {


    @Query("CREATE (d:DeliveryBoy { deliveryBoyId : {deliveryBoyId}, deliveryBoyName : {deliveryBoyName}, mobile : {mobile}, status : {status}, location : {location} }) RETURN d")
    public DeliveryBoy saveDeliveryBoy(@Param("deliveryBoyId") String deliveryBoyId, @Param("deliveryBoyName") String deliveryBoyName,@Param("mobile") Long mobile,@Param("status") String status, @Param("location") String location);


    @Query("MATCH (d:DeliveryBoy) WHERE d.deliveryBoyId = {deliveryBoyId} RETURN d")
    public DeliveryBoy findByDeliveryBoyId(@Param("deliveryBoyId") String deliveryBoyId);


    @Query("MATCH (d:DeliveryBoy) WHERE d.deliveryBoyId = {deliveryBoyId} SET  d.deliveryBoyName = {deliveryBoyName}, d.mobile = {mobile}, d.status = {status}, d.location = {location} RETURN d")
    public DeliveryBoy updateDeliveryBoy(@Param("deliveryBoyId") String deliveryBoyId, @Param("deliveryBoyName") String deliveryBoyName,@Param("mobile") Long mobile,@Param("status") String status, @Param("location") String location);


    @Query("MATCH (rs:Restaurant),(d:DeliveryBoy) WHERE rs.restaurantId = {restaurantId} AND d.deliveryBoyId = {deliveryBoyId} CREATE (rs)-[r:LINKED_TO { distance : {distance}}]->(d)")
    public void createRestaurantDeliveryBoyRelation(@Param("restaurantId") String restaurantId, @Param("deliveryBoyId") String deliveryBoyId, @Param("distance") double distance);


    @Query("MATCH (rs:Restaurant),(d:DeliveryBoy) WHERE rs.restaurantId = {restaurantId} AND d.deliveryBoyId = {deliveryBoyId} CREATE (rs)-[r:PICKS_FROM]->(d)")
    public void createPicksFromRelation(@Param("restaurantId") String restaurantId, @Param("deliveryBoyId") String deliveryBoyId);


    @Query("MATCH (d:DeliveryBoy),(c:Charity) WHERE d.deliveryBoyId = {deliveryBoyId} AND c.charityId = {charityId} CREATE (d)-[r:LINKED_TO { distance : {distance}}]->(c)")
    public void createDeliveryBoyCharityRelation(@Param("deliveryBoyId") String deliveryBoyId, @Param("charityId") String charityId, @Param("distance") double distance);


    @Query("MATCH (d:DeliveryBoy),(c:Charity) WHERE d.deliveryBoyId = {deliveryBoyId} AND c.charityId = {charityId} CREATE (d)-[r:DELIVERS_TO]->(c)")
    public void createDeliversToRelation(@Param("deliveryBoyId") String deliveryBoyId,@Param("charityId") String charityId);


    @Query("MATCH (d:DeliveryBoy) RETURN d")
    public List<DeliveryBoy> fetchDeliveryBoys();

    @Query("MATCH (d:DeliveryBoy)-[r:DELIVERS_TO]->(c:Charity) WHERE c.charityId = {charityId} RETURN d")
    public DeliveryBoy fetchDeliveryBoysForCharity(@Param("charityId") String charityId);

    @Query("MATCH (rs:Restaurant)-[r:PICKS_FROM]->(d:DeliveryBoy)  WHERE rs.restaurantId = {restaurantId} RETURN d")
    public DeliveryBoy fetchDeliveryBoysForRestaurant(@Param("restaurantId") String restaurantId);

    @Query("MATCH (rs:Restaurant)-[r:PICKS_FROM]->(d:DeliveryBoy) WHERE d.deliveryBoyId = {deliveryBoyId} RETURN rs")
    public List<Restaurant> fetchAssignedResturantsForDeliveryBoy(@Param("deliveryBoyId") String deliveryBoyId);

    @Query("MATCH (d:DeliveryBoy)-[r:DELIVERS_TO]->(c:Charity) WHERE d.deliveryBoyId = {deliveryBoyId} RETURN c")
    public Charity fetchAssignedCharityForDeliveryBoy(@Param("deliveryBoyId") String deliveryBoyId);

    public DeliveryBoy findByDeliveryBoyName(@Param("deliveryBoyName") String deliveryBoyName);


    @Query("MATCH (d:DeliveryBoy { deliveryBoyId: {deliveryBoyId} }) DETACH DELETE d")
    public void removeDeliveryBoy(@Param("deliveryBouId") String deliveryBoyId);


    @Query("MATCH (d:DeliveryBoy { deliveryBoyId : {deliveryBoyId} })<-[r:PICKS_FROM]-() DELETE r")
    public void removeRestaurantDeliveryBoyRelation(@Param("deliveryBoyId") String deliveryBoyId);


    @Query("MATCH (d:DeliveryBoy { deliveryBoyId : {deliveryBoyId} })-[r:DELIVERS_TO]->() DELETE r")
    public void removeDeliveryBoyCharityRelation(@Param("deliveryBoyId") String deliveryBoyId);


    @Query("MATCH (d:DeliveryBoy)-[r:LINKED_TO]->(c:Charity) WHERE c.charityId = {charityId} AND d.status = 'available' RETURN d ORDER BY r.distance")
    public List<DeliveryBoy> getSortedDeliveryBoysByDistanceAndAvailability(@Param("charityId") String charityId);


    @Query("MATCH (d:DeliveryBoy) WHERE d.deliveryBoyId = {deliveryBoyId} SET d.status = {status}, d.location = {location}")
    public DeliveryBoy updateDeliveryBoyStatusAndLocation(@Param("deliveryBoyId") String deliveryBoyId, @Param("status") String status, @Param("location") String location);


    @Query("MATCH (d : DeliveryBoy) SET d.status='available'")
    public void resetAvailabilityStatus();


    @Query("MATCH (d:DeliveryBoy)-[r:DELIVERS_TO]->() DELETE r")
    public void removeDeliversToRelation();


    @Query("MATCH ()-[r:PICKS_FROM]->(d:DeliveryBoy) DELETE r")
    public void removePicksFromRelation();

    @Query("MATCH ()-[r:LINKED_TO]-() DELETE r")
    public void removeLinkedToRelation();

}