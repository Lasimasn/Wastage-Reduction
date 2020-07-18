package com.stackroute.registrationserver.service;

import com.stackroute.registrationserver.domain.Charities;
import com.stackroute.registrationserver.domain.CharityProfile;
import com.stackroute.registrationserver.exceptions.EntityAlreadyExistsException;
import com.stackroute.registrationserver.exceptions.EntityNotExistsException;
import com.stackroute.registrationserver.repository.CharityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharityServiceImpl implements CharityService {

    CharityRepository charityRepository;

    @Autowired
    public CharityServiceImpl(CharityRepository charityRepository){

        this.charityRepository = charityRepository;

    }

    @Override
    public CharityProfile saveCharity(Charities charity) throws EntityAlreadyExistsException {
        if(charityRepository.existsById(charity.getUsername())) {
            throw new EntityAlreadyExistsException("Charity Already Exists");
        }
        else {
            CharityProfile charityProfile = new CharityProfile(charity.getUsername(), charity.getEmail(), charity.getRole(), charity.getName(), charity.getMobile(), charity.getAddress(), charity.getLocation(), charity.getFoodRequirement(), charity.getCertificateNo(), charity.getCertificateName());
            CharityProfile savedCharity = charityRepository.save(charityProfile);
            return savedCharity;
        }

    }

    @Override
    public List<CharityProfile> displayCharity() {

        return charityRepository.findAll();
    }

    @Override
    public CharityProfile updateCharity(Charities charity) throws EntityNotExistsException {
        if(!charityRepository.existsById(charity.getUsername())) {
            throw new EntityNotExistsException("Charity Not Exists");
        }
        else {
            CharityProfile charityProfile = new CharityProfile(charity.getUsername(), charity.getEmail(), charity.getRole(), charity.getName(), charity.getMobile(), charity.getAddress(), charity.getLocation(), charity.getFoodRequirement(), charity.getCertificateNo(), charity.getCertificateName());
            return charityRepository.save(charityProfile);
        }
    }

    @Override
    public CharityProfile displayCharityByUsername(String username) throws EntityNotExistsException {
        if(charityRepository.existsById(username)){
            CharityProfile charity = charityRepository.displayCharityByUsername(username);
            return charity;
        }
        else {
            throw new EntityNotExistsException("Charity Not Exists");
        }
    }
}
