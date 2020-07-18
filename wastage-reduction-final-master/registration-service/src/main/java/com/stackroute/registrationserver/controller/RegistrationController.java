package com.stackroute.registrationserver.controller;

import com.stackroute.rabbitmq.model.RestaurantMQ;
import com.stackroute.registrationserver.domain.*;
import com.stackroute.registrationserver.exceptions.EntityAlreadyExistsException;
import com.stackroute.registrationserver.exceptions.EntityNotExistsException;
import com.stackroute.registrationserver.service.CharityService;
import com.stackroute.registrationserver.service.DeliveryBoyService;
import com.stackroute.registrationserver.service.RabbitService;
import com.stackroute.registrationserver.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
@CrossOrigin(origins = "*")
public class RegistrationController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private CharityService charityService;

    @Autowired
    private DeliveryBoyService deliveryBoyService;

    @Autowired
    private RabbitService rabbitService;

    @PostMapping("restaurant-profile")
    public ResponseEntity<RestaurantProfile> saveRestaurant(@RequestBody Restaurants restaurant) throws EntityAlreadyExistsException {

        ResponseEntity responseEntity;
        RestaurantProfile returnRestaurant = restaurantService.saveRestaurant(restaurant);
        responseEntity = new ResponseEntity<RestaurantProfile>(returnRestaurant, HttpStatus.CREATED);
        rabbitService.sendToRestaurantRabbitMq(restaurant);
        return responseEntity;
    }
//    @GetMapping("restaurant-profile")
//    public ResponseEntity<List<RestaurantMQ>> displayRestaurant()
//    {
//        ResponseEntity responseEntity;
//
//        try{
//
//            responseEntity=new ResponseEntity(restaurantService.displayRestaurants(),HttpStatus.CREATED);
//
//        }
//        catch (Exception e){
//
//            responseEntity=new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
//
//        }
//        return responseEntity;
//    }

    @GetMapping("restaurant-profile")
    public ResponseEntity<RestaurantProfile> displayRestaurantByUsername(@RequestParam String username) throws EntityNotExistsException
    {
        ResponseEntity responseEntity;
        RestaurantProfile restaurant = restaurantService.displayRestaurantByUsername(username);
        return new ResponseEntity<RestaurantProfile>(restaurant, HttpStatus.OK);
    }

    @PutMapping("restaurant-profile")
    public ResponseEntity updateRestaurant(@RequestBody Restaurants restaurant) throws EntityNotExistsException
    {
        ResponseEntity responseEntity;
        responseEntity = new ResponseEntity(restaurantService.updateRestaurant(restaurant),HttpStatus.CREATED);
        rabbitService.sendToRestaurantUpdateRabbitMq(restaurant);
        return responseEntity;
    }

    @PostMapping("charity-profile")
    public ResponseEntity<CharityProfile> saveCharity(@RequestBody Charities charity) throws EntityAlreadyExistsException {

        ResponseEntity responseEntity;
        CharityProfile returnCharity = charityService.saveCharity(charity);
        responseEntity = new ResponseEntity<CharityProfile>(returnCharity, HttpStatus.CREATED);
        rabbitService.sendToCharityRabbitMq(charity);
        return responseEntity;
    }

//    @GetMapping("charity-profile")
//    public ResponseEntity<List<CharityProfile>> displayCharity()
//    {
//        ResponseEntity responseEntity;
//
//        try{
//
//            responseEntity=new ResponseEntity(charityService.displayCharity(),HttpStatus.CREATED);
//
//        }
//        catch (Exception e){
//
//            responseEntity=new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
//
//        }
//        return responseEntity;
//    }

    @GetMapping("charity-profile")
    public ResponseEntity<CharityProfile> displayCharityByUsername(@RequestParam String username) throws EntityNotExistsException
    {
        ResponseEntity responseEntity;
        CharityProfile charity = charityService.displayCharityByUsername(username);
        return new ResponseEntity<CharityProfile>(charity, HttpStatus.OK);
    }

    @PutMapping("charity-profile")
    public ResponseEntity updateCharity(@RequestBody Charities charity) throws EntityNotExistsException
    {
        rabbitService.sendToCharityUpdateRabbitMq(charity);
        return new ResponseEntity(charityService.updateCharity(charity),HttpStatus.CREATED);
    }

    @PostMapping("deliveryBoy-profile")
    public ResponseEntity<DeliveryBoyProfile> saveDeliveryBoy(@RequestBody DeliveryBoys deliveryBoys) throws EntityAlreadyExistsException {
        ResponseEntity responseEntity;
        DeliveryBoyProfile returnDeliveryBoy = deliveryBoyService.saveDeliveryBoy(deliveryBoys);
        responseEntity = new ResponseEntity<DeliveryBoyProfile>(returnDeliveryBoy, HttpStatus.CREATED);
        rabbitService.sendToDeliveryBoyMQ(deliveryBoys);
        return responseEntity;
    }

    @GetMapping("deliveryBoy-profile")
    public ResponseEntity<DeliveryBoyProfile> displayDeliveryBoy(@RequestParam String username) throws EntityNotExistsException
    {
        ResponseEntity responseEntity;
        responseEntity=new ResponseEntity(deliveryBoyService.displayDeliveryBoy(username),HttpStatus.CREATED);
        return responseEntity;
    }

    @PutMapping("deliveryBoy-profile")
    public ResponseEntity updateDeliveryBoy(@RequestBody DeliveryBoys deliveryBoys) throws EntityNotExistsException
    {
        ResponseEntity responseEntity;
        responseEntity=new ResponseEntity(deliveryBoyService.updateDeliveryBoy(deliveryBoys),HttpStatus.CREATED);
        rabbitService.sendToDeliveryBoyUpdateMQ(deliveryBoys);
        return responseEntity;
    }
}
