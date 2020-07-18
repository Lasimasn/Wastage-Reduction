package com.stackroute.registrationserver.repository;

import com.stackroute.registrationserver.domain.CharityProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharityRepository extends JpaRepository<CharityProfile, String> {
    @Query(value = "SELECT * FROM charity_profile WHERE username = ?1", nativeQuery = true)
    public CharityProfile displayCharityByUsername(String username);
}
