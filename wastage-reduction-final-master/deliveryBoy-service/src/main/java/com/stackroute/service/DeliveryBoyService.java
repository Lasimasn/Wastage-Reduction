package com.stackroute.service;

import com.stackroute.domain.DeliveryBoy;
import com.stackroute.domain.DeliveryBoyLiveStatus;

import java.util.List;

public interface DeliveryBoyService {
    public DeliveryBoy saveDeliveryBoyLogs(DeliveryBoy deliveryBoy) throws Exception;

    public List<DeliveryBoy> displayDeliveryBoyLogs();

    public DeliveryBoy fetchDeliveryBoy(String username);

    public DeliveryBoyLiveStatus fetchDeliveryBoyStatus(String username);


}
