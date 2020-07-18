package com.stackroute.registrationserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantProfile {

    @Id
    private String username;
    private String email;
    private String role;
    private String name;
    private long mobile;
    private String address;
    private String location;
    private String certificateNo;
    private String certificateName;

}
