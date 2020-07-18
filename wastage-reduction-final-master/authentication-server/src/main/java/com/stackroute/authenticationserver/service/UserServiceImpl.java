package com.stackroute.authenticationserver.service;

import com.stackroute.authenticationserver.exception.UserNotExistsException;
import com.stackroute.authenticationserver.model.User;
import com.stackroute.authenticationserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){

        this.userRepository = userRepository;

    }

    @Override
    public User getUserByUsername(String username) throws UserNotExistsException {

        if(userRepository.existsById(username))
        {
            return userRepository.findByUsername(username);
        }
        else {
            throw new UserNotExistsException("User Not Exists");
        }
    }

}
