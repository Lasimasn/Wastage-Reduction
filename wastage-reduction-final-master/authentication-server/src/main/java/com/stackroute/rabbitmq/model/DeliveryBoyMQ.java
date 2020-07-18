package com.stackroute.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryBoyMQ {

    private String username;
    private String password;
    private String email;
    private String role;
    private String deliveryBoyName;
    private long mobile;
    private String address;
    private String licenseNo;
    private String licenseName;
}
