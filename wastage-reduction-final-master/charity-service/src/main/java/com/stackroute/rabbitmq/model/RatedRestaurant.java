package com.stackroute.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class RatedRestaurant {
    private String username;
    private int logId;
    private double rating;

    public RatedRestaurant(String username, int logId, double rating) {
        this.username = username;
        this.logId = logId;
        this.rating = rating;
    }
}
