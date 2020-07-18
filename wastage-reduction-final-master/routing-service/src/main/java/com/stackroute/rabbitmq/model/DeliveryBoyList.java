package com.stackroute.rabbitmq.model;


import java.util.List;

public class DeliveryBoyList {
    private List<DeliveryBoyStatus> deliveryBoys;

    public DeliveryBoyList(List<DeliveryBoyStatus> deliveryBoys) {
        this.deliveryBoys = deliveryBoys;
    }

    public List<DeliveryBoyStatus> getDeliveryBoys() {
        return deliveryBoys;
    }

    public void setDeliveryBoys(List<DeliveryBoyStatus> deliveryBoys) {
        this.deliveryBoys = deliveryBoys;
    }
}
