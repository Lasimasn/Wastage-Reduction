package com.stackroute.registrationserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Charities {

    private String username;
    private String password;
    private String email;
    private String role;
    private String name;
    private long mobile;
    private String address;
    private String location;
    private long foodRequirement;
    private String certificateNo;
    private String certificateName;
}
