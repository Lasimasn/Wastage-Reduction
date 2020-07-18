package com.stackroute.repository;

import com.stackroute.domain.Charity;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "charities", path = "charities")

public interface CharityRepository extends Neo4jRepository<Charity, Long> {


    @Query("CREATE (c:Charity { charityId : {charityId}, charityName : {charityName}, foodRequirement : {foodRequirement}, location : {location}, foodAvailable : {foodAvailable}, precedence : {precedence}  }) RETURN c")
    public Charity saveCharity(@Param("charityId") String charityId, @Param("charityName") String charityName, @Param("foodRequirement") String foodRequirement,@Param("location") String location, @Param("foodAvailable") String foodAvailable, @Param("precedence") double precedence);


    @Query("MATCH (c:Charity) WHERE  c.charityId = {charityId} SET c.charityName = {charityName}, c.foodRequirement = {foodRequirement}, c.location = {location}, c.foodAvailable = {foodAvailable} RETURN c")
    public Charity updateCharity(@Param("charityId") String charityId, @Param("charityName") String charityName, @Param("foodRequirement") String foodRequirement,@Param("location") String location, @Param("foodAvailable") String foodAvailable);


    @Query("MATCH (rs:Restaurant),(c:Charity) WHERE rs.restaurantId = {restaurantId} AND c.charityId = {charityId} CREATE (rs)-[r:DONATES_TO { distance : {distance} , status : {status}}]->(c)")
    public void createRestaurantCharityRelation(@Param("restaurantId") String restaurantId, @Param("charityId") String charityId, @Param("distance") double distance, @Param("status") String status);


    @Query("MATCH (c:Charity) RETURN c")
    public List<Charity> fetchCharities();


    @Query("MATCH (c:Charity) WHERE c.charityId = {charityId} RETURN c")
    public Charity findByCharityId(@Param("charityId") String charityId);


    @Query("MATCH (c:Charity { charityId: {charityId} }) DETACH DELETE c")
    public void removeCharity(@Param("charityId") String charityId);


    @Query("MATCH ()-[r:DONATES_TO]->() DELETE r")
    public void removeDonatesToRelation();


    @Query("MATCH (c:Charity) RETURN c ORDER BY c.precedence DESC")
    public List<Charity> getSortedCharitiesByPrecedence();


    @Query("MATCH (rs:Restaurant)-[r:DONATES_TO]->(c:Charity) WHERE rs.restaurantId = {restaurantId} AND c.charityId = {charityId} SET r.status = 'yes'")
    public void updateDonatedStatusOnRelation(@Param("restaurantId") String restaurantId, @Param("charityId") String charityId);


    @Query("MATCH (c { charityId: {charityId }}) SET c.foodAvailable = {foodAvailable}")
    public void updateFoodAvailable(@Param("charityId") String charityId, @Param("foodAvailable") String foodAvailable);


    @Query("MATCH (c { charityId: {charityId }}) SET c.precedence = {precedence}")
    public void updatePrecedence(@Param("charityId") String charityId, @Param("precedence") double precedence);


    @Query("MATCH (c : Charity) SET c.foodAvailable='0'")
    public void resetFoodAvailable();


    @Query("MATCH (c : Charity) SET c.precedence = 1.0")
    public void resetPrecedence();

    @Query("MATCH (d:DeliveryBoy)-[r:DELIVERS_TO]->(c:Charity) WHERE c.charityId = {charityId} RETURN c.charityId, c.foodAvailable, d.deliveryBoyId, d.deliveryBoyName")
    public String[] sendDetailsToCharity(@Param("charityId") String charityId);
}
