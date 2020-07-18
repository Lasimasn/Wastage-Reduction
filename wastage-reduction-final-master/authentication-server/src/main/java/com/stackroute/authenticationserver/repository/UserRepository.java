package com.stackroute.authenticationserver.repository;


import com.stackroute.authenticationserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);

}
