package com.stackroute.domain;

import lombok.Data;

@Data
public class DeliveryBoyActivity {
    private String deliveryboyId;
    private String status;
    private String location;

    public DeliveryBoyActivity() {
    }

    public DeliveryBoyActivity(String deliveryboyId, String status, String location) {
        this.deliveryboyId = deliveryboyId;
        this.status = status;
        this.location = location;
    }

    public String getDeliveryboyId() {
        return deliveryboyId;
    }

    public void setDeliveryboyId(String deliveryboyId) {
        this.deliveryboyId = deliveryboyId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
