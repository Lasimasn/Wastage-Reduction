package com.stackroute.authenticationserver.model;

import org.springframework.security.core.userdetails.UserDetails;

public class JwtResponse {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    private User user;

    public JwtResponse(String jwttoken, User user) {

        this.jwttoken = jwttoken;
        this.user = user;
    }

    public String getToken() {
        return this.jwttoken;
    }

    public User getUserDetails() {
        return user;
    }

}
