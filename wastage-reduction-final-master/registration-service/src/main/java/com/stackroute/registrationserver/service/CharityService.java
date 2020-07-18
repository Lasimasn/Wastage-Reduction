package com.stackroute.registrationserver.service;

import com.stackroute.registrationserver.domain.Charities;
import com.stackroute.registrationserver.domain.CharityProfile;
import com.stackroute.registrationserver.exceptions.EntityAlreadyExistsException;
import com.stackroute.registrationserver.exceptions.EntityNotExistsException;

import java.util.List;

public interface CharityService {

    CharityProfile saveCharity(Charities charity) throws EntityAlreadyExistsException;
    List<CharityProfile> displayCharity();
    CharityProfile updateCharity(Charities charity)throws EntityNotExistsException;
    CharityProfile displayCharityByUsername(String username) throws  EntityNotExistsException;
}