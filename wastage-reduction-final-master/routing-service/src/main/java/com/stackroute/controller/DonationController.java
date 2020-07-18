package com.stackroute.controller;

import com.stackroute.domain.*;
import com.stackroute.repository.DeliveryBoyRepository;
import com.stackroute.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class DonationController {

    @Autowired
    DonationService donationService;

    @Autowired
    DeliveryBoyRepository deliveryBoyRepository;

    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }


    @RequestMapping("/addRestaurant")
    public Restaurant saveRestaurant(@RequestParam String restaurantId, @RequestParam String restaurantName, @RequestParam String location) {
        return donationService.saveRestaurant(restaurantId, restaurantName, location);
    }


    @RequestMapping("/addCharity")
    public Charity saveCharity(@RequestParam String charityId, @RequestParam String charityName, @RequestParam String foodRequirement, @RequestParam String location) {
        return donationService.saveCharity(charityId, charityName, foodRequirement, location);
    }


    @RequestMapping("/addDeliveryBoy")
    public DeliveryBoy saveDeliveryBoy(@RequestParam String deliveryBoyId, @RequestParam String deliveryBoyName,@RequestParam Long mobile, @RequestParam String status, @RequestParam String location) {
        return donationService.saveDeliveryBoy(deliveryBoyId, deliveryBoyName,mobile, status, location);
    }


    @PutMapping("/updateRestaurantDetails")
    public ResponseEntity<?> updateRestaurantFoodAvailability(@RequestBody RestaurantActivity restaurantActivity) {

        return new ResponseEntity<String>((donationService.updateRestaurantFoodAvailability(restaurantActivity.getRestaurantId(), restaurantActivity.getFoodAvailability())), HttpStatus.ACCEPTED);
    }


    @PutMapping("/updateDeliveryBoyDetails")
    public ResponseEntity updateDeliveryBoyStatusAndLocation(@RequestBody DeliveryBoyActivity deliveryBoyActivity) {
        return new ResponseEntity((donationService.updateDeliveryBoyStatusAndLocation(deliveryBoyActivity.getDeliveryboyId(),deliveryBoyActivity.getStatus(),deliveryBoyActivity.getLocation())),HttpStatus.ACCEPTED);
    }


    @RequestMapping("/donatesTo")
    public String createRestaurantCharityRelation(@RequestParam String restaurantId, @RequestParam String charityId, @RequestParam int distance) {
        return donationService.createRestaurantCharityRelation(restaurantId, charityId, distance);
    }


    @RequestMapping("/linkedToRD")
    public String createRestaurantDeliveryBoyRelation(@RequestParam String restaurantId, @RequestParam String deliveryBoyId, @RequestParam int distance) {
        return donationService.createRestaurantDeliveryBoyRelation(restaurantId, deliveryBoyId, distance);
    }

    @RequestMapping("/picksFrom")
    public String createPicksFromRelation(@RequestParam String restaurantId, @RequestParam String deliveryBoyId) {
        return donationService.createPicksFromRelation(restaurantId, deliveryBoyId);
    }

    @RequestMapping("/linkedToDC")
    public String createDeliveryBoyCharityRelation(@RequestParam String deliveryBoyId, @RequestParam String charityId, @RequestParam int distance) {
        return donationService.createDeliveryBoyCharityRelation(deliveryBoyId, charityId, distance);
    }

    @RequestMapping("/deliversTo")
    public String createDeliversToRelation(@RequestParam String deliveryBoyId, @RequestParam String charityId) {
        return donationService.createDeliversToRelation(deliveryBoyId, charityId);
    }


    @RequestMapping("/deliveryBoy")
    public DeliveryBoy getDeliveryBoy(@RequestParam String deliveryBoyName) {
        return donationService.findByDeliveryBoyName(deliveryBoyName);
    }


    @RequestMapping("/removeDonatesTo")
    public String removeRestaurantCharityRelation(@RequestParam String charityId) {
        return donationService.removeRestaurantCharityRelation(charityId);
    }


    @RequestMapping("/removeLinkedToRD")
    public String removeRestaurantDeliveryBoyRelation(@RequestParam String deliveryBoyId) {
        return donationService.removeRestaurantDeliveryBoyRelation(deliveryBoyId);
    }


    @RequestMapping("/removeLinkedToRC")
    public String removeDeliveryBoyRestaurantRelation(@RequestParam String deliveryBoyId) {
        return donationService.removeDeliveryBoyCharityRelation(deliveryBoyId);
    }


    @GetMapping("/removeRestaurant")
    public String removeRestaurant(@RequestParam String restaurantId) {
        return donationService.removeRestaurant(restaurantId);
    }


    @GetMapping("/removeCharity")
    public String removeCharity(@RequestParam String charityId) {
        return donationService.removeCharity(charityId);
    }


    @GetMapping("/removeDeliveryBoy")
    public String removeDeliveryBoy(@RequestParam String deliveryBoyId) {
        return donationService.removeDeliveryBoy(deliveryBoyId);
    }

    @RequestMapping("/startRouting")
    public String initiateRoutingProtocol() {
        return donationService.startRouting();
    }

    @RequestMapping("/resetStats")
    public String resetStats() {
        return donationService.resetStats();
    }

    @RequestMapping("/resetPrecedence")
    public String resetPrecedence() {
        return donationService.resetPrecedence();
    }

    @RequestMapping("/sendToCharity")
    public String[] sendtocharity(@RequestParam String charityId) {
        return donationService.sendToCharity(charityId);
    }

    @RequestMapping("/fetchBoys")
    public List<DeliveryBoy> fetchBoys(){
        return deliveryBoyRepository.fetchDeliveryBoys();
    }
}