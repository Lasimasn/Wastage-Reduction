package com.stackroute.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import java.util.List;

@Data
public class CharitySave {

    private String username;
    private String charityName;
    private String location;
    private String foodReceived;

    public CharitySave() {
    }

    public CharitySave(String username, String charityName, String location, String foodReceived) {
        this.username = username;
        this.charityName = charityName;
        this.location = location;
        this.foodReceived = foodReceived;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCharityName() {
        return charityName;
    }

    public void setCharityName(String charityName) {
        this.charityName = charityName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFoodReceived() {
        return foodReceived;
    }

    public void setFoodReceived(String foodReceived) {
        this.foodReceived = foodReceived;
    }
}
