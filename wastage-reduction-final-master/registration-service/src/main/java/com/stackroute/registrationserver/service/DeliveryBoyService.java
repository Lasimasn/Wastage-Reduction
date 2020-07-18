package com.stackroute.registrationserver.service;

import com.stackroute.registrationserver.domain.DeliveryBoyProfile;
import com.stackroute.registrationserver.domain.DeliveryBoys;
import com.stackroute.registrationserver.exceptions.EntityAlreadyExistsException;
import com.stackroute.registrationserver.exceptions.EntityNotExistsException;

import java.util.Optional;

public interface DeliveryBoyService {

    DeliveryBoyProfile saveDeliveryBoy(DeliveryBoys deliveryBoys) throws EntityAlreadyExistsException;
    Optional<DeliveryBoyProfile> displayDeliveryBoy(String username) throws EntityNotExistsException;
    public DeliveryBoyProfile updateDeliveryBoy(DeliveryBoys deliveryBoys) throws EntityNotExistsException;
}