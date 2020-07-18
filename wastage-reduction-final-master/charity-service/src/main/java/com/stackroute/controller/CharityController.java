package com.stackroute.controller;

import com.stackroute.domain.Charity;
import com.stackroute.domain.Rating;
import com.stackroute.service.CharityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/v1")
@CrossOrigin(origins = "*")
public class CharityController {
    @Autowired
    CharityService charityService;

    @Autowired
    public  CharityController(CharityService charityService)
    {
        this.charityService = charityService;
    }
    ResponseEntity responseEntity;

    @PostMapping("charity-logs")
    public ResponseEntity<?> saveCharityLogs (@RequestBody String username) throws Exception
    {

        responseEntity=new ResponseEntity(charityService.saveCharityLogs(username), HttpStatus.CREATED);
        return  responseEntity;
    }

    @GetMapping("charity-logs")
    public ResponseEntity displayCharityLogs(@RequestParam String username)
    {
        return  new ResponseEntity(charityService.fetchCharity(username),HttpStatus.OK);
    }

    @GetMapping("charity-status")
    public ResponseEntity displayCharityStatus(@RequestParam String username)
    {
        return  new ResponseEntity(charityService.fetchCharityStatus(username),HttpStatus.OK);
    }

    @PostMapping("charity-rating")
    public ResponseEntity<?> saveRating (@RequestBody Rating rating) throws Exception
    {

        responseEntity=new ResponseEntity(charityService.saveRating(rating), HttpStatus.CREATED);
        return  responseEntity;
    }
    @GetMapping("charity-slider")
    public ResponseEntity displayCharitySlider()
    {
        return  new ResponseEntity(charityService.displayCharitySeeder(),HttpStatus.OK);
    }


}
