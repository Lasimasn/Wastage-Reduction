package com.stackroute.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class RestaurantLiveStatus {

    @Id
    String username;
    Logs logs;

    public RestaurantLiveStatus() {
    }

    public RestaurantLiveStatus(String username, Logs logs) {
        this.username = username;
        this.logs = logs;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Logs getLogs() {
        return logs;
    }

    public void setLogs(Logs logs) {
        this.logs = logs;
    }
}
