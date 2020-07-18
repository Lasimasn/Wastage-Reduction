package com.stackroute.registrationserver.service;

import com.stackroute.registrationserver.domain.DeliveryBoyProfile;
import com.stackroute.registrationserver.domain.DeliveryBoys;
import com.stackroute.registrationserver.exceptions.EntityAlreadyExistsException;
import com.stackroute.registrationserver.exceptions.EntityNotExistsException;
import com.stackroute.registrationserver.repository.DeliveryBoyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveryBoyServiceImpl implements DeliveryBoyService {
    DeliveryBoyRepository deliveryBoyRepository;

    @Autowired
    public DeliveryBoyServiceImpl(DeliveryBoyRepository deliveryBoyRepository){

        this.deliveryBoyRepository = deliveryBoyRepository;

    }

    @Override
    public DeliveryBoyProfile saveDeliveryBoy(DeliveryBoys deliveryBoys) throws EntityAlreadyExistsException {

        if(deliveryBoyRepository.existsById(deliveryBoys.getUsername()))
        {
            throw new EntityAlreadyExistsException("DeliveryBoy Already Exists");
        }
        else {
            System.out.println(deliveryBoys);
            DeliveryBoyProfile deliveryBoyProfile = new DeliveryBoyProfile(deliveryBoys.getUsername(), deliveryBoys.getEmail(), deliveryBoys.getRole(), deliveryBoys.getName(), deliveryBoys.getMobile(), deliveryBoys.getAddress(), deliveryBoys.getLicenseNo(), deliveryBoys.getLicenseName());
            DeliveryBoyProfile savedDeliveryBoyDetails = deliveryBoyRepository.save(deliveryBoyProfile);
            return savedDeliveryBoyDetails;
        }
    }

    @Override
    public Optional<DeliveryBoyProfile> displayDeliveryBoy(String username) throws EntityNotExistsException {
        if(deliveryBoyRepository.existsById(username))
        {
            return deliveryBoyRepository.findById(username);
        }
        else {

            throw new EntityNotExistsException("DeliveryBoy Not Exists");
        }
    }

    @Override
    public DeliveryBoyProfile updateDeliveryBoy(DeliveryBoys deliveryBoys) throws EntityNotExistsException {
        if(!deliveryBoyRepository.existsById(deliveryBoys.getUsername()))
        {
            throw new EntityNotExistsException("DeliveryBoy Not Exists");
        }
        else {
            DeliveryBoyProfile deliveryBoyProfile = new DeliveryBoyProfile(deliveryBoys.getUsername(), deliveryBoys.getEmail(), deliveryBoys.getRole(), deliveryBoys.getName(), deliveryBoys.getMobile(), deliveryBoys.getAddress(), deliveryBoys.getLicenseNo(), deliveryBoys.getLicenseName());
            return deliveryBoyRepository.save(deliveryBoyProfile);
        }
    }

}