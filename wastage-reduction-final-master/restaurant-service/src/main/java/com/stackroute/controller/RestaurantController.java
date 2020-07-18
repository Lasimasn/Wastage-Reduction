package com.stackroute.controller;
import com.stackroute.domain.Restaurant;
import com.stackroute.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/v1")
@CrossOrigin(origins = "*")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("restaurant-logs")
    public ResponseEntity<?> saveRestaurantLog(@RequestBody String username) throws Exception
    {
        ResponseEntity responseEntity;
        
        responseEntity=new ResponseEntity<Restaurant>(restaurantService.saveRestaurantLog(username), HttpStatus.CREATED);
        System.out.println("Addition to logs is successful for  : "+ username);
        return  responseEntity;
    }

    @GetMapping("restaurant-logs")
    public ResponseEntity getRestaurantLogs(@RequestParam String username)
    {
            return  new ResponseEntity(restaurantService.fetchRestaurantLogs(username),HttpStatus.OK);

    }

    @GetMapping("restaurant-status")
    public ResponseEntity getRestaurantStatus(@RequestParam String username)
    {
        return  new ResponseEntity(restaurantService.fetchRestaurantLiveStatus(username),HttpStatus.OK);
    }

}

