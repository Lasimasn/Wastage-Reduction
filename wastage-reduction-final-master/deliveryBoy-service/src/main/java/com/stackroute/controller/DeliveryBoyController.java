package com.stackroute.controller;

import com.stackroute.domain.DeliveryBoy;
import com.stackroute.service.DeliveryBoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/v1")
@CrossOrigin(origins = "*")
public class DeliveryBoyController {
    @Autowired
    DeliveryBoyService deliveryBoyService;

    @Autowired
    public DeliveryBoyController(DeliveryBoyService deliveryBoyService)
    {
        this.deliveryBoyService = deliveryBoyService;
    }
    ResponseEntity responseEntity;

    @PostMapping("deliveryBoy-logs")
    public ResponseEntity<?> saveDeliveryBoyLogs (@RequestBody DeliveryBoy deliveryBoy) throws Exception
    {

        deliveryBoyService.saveDeliveryBoyLogs(deliveryBoy);
        responseEntity=new ResponseEntity(deliveryBoy, HttpStatus.CREATED);
        return  responseEntity;
    }

    @GetMapping("deliveryBoy-logs")
    public ResponseEntity displayDeliveryBoyLogs(@RequestParam String username)
    {
        return  new ResponseEntity(deliveryBoyService.fetchDeliveryBoy(username),HttpStatus.OK);
    }

    @GetMapping("deliveryBoy-status")
    public ResponseEntity displayDeliveryBoyStatus(@RequestParam String username)
    {
        return  new ResponseEntity(deliveryBoyService.fetchDeliveryBoyStatus(username),HttpStatus.OK);
    }


}
