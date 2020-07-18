package com.stackroute.service;

import com.stackroute.domain.DeliveryBoy;
import com.stackroute.domain.DeliveryBoyLiveStatus;
import com.stackroute.repository.DeliveryBoyLiveStatusRepository;
import com.stackroute.repository.DeliveryBoyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeliveryBoyServiceImpl implements DeliveryBoyService {

    @Autowired
    DeliveryBoyRepository deliveryBoyRepository;

    @Autowired
    DeliveryBoyLiveStatusRepository deliveryBoyLiveStatusRepository;

    public DeliveryBoyServiceImpl(){}

    public DeliveryBoyServiceImpl(DeliveryBoyRepository deliveryBoyRepository){this.deliveryBoyRepository = deliveryBoyRepository;}

    @Override
    public DeliveryBoy saveDeliveryBoyLogs(DeliveryBoy deliveryBoy) throws Exception{

        if(deliveryBoyRepository.existsById(deliveryBoy.getUsername())) {
            throw new Exception("Delivery Boy already exists");
        }
        else
            return deliveryBoyRepository.save(deliveryBoy);
    }

    @Override
    public DeliveryBoy fetchDeliveryBoy(String username) {
        return deliveryBoyRepository.findById(username).get();
    }

    @Override
    public List<DeliveryBoy> displayDeliveryBoyLogs() {
        return deliveryBoyRepository.findAll();
    }

    @Override
    public DeliveryBoyLiveStatus fetchDeliveryBoyStatus(String username) {
        return deliveryBoyLiveStatusRepository.findById(username).get();
    }
}
