package com.stackroute.authenticationserver.controller;

import com.stackroute.authenticationserver.config.JwtTokenUtil;
import com.stackroute.authenticationserver.exception.UserNotExistsException;
import com.stackroute.authenticationserver.model.CheckResponse;
import com.stackroute.authenticationserver.model.JwtRequest;
import com.stackroute.authenticationserver.model.JwtResponse;

import com.stackroute.authenticationserver.model.User;
import com.stackroute.authenticationserver.service.JwtUserDetailsService;
import com.stackroute.authenticationserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication/")
@CrossOrigin(origins = "*")
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws UserNotExistsException {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        User user = userService.getUserByUsername(userDetails.getUsername());

        return ResponseEntity.ok(new JwtResponse(token, user));
    }

    @GetMapping(value = "/checkUser" )
    public ResponseEntity<CheckResponse> checkUser() {
        String s = "This is a registered User";
        return ResponseEntity.ok(new CheckResponse(s));
    }


    private void authenticate(String username, String password) throws DisabledException, BadCredentialsException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new DisabledException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("INVALID_CREDENTIALS", e);
        }
    }

}
