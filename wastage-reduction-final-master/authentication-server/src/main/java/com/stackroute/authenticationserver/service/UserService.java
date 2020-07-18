package com.stackroute.authenticationserver.service;

import com.stackroute.authenticationserver.exception.UserNotExistsException;
import com.stackroute.authenticationserver.model.User;

public interface UserService {

    User getUserByUsername(String username) throws UserNotExistsException;
}
