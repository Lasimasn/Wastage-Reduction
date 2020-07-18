package com.stackroute.registrationserver.repository;

import com.stackroute.registrationserver.domain.DeliveryBoyProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryBoyRepository extends JpaRepository<DeliveryBoyProfile, String> {
}
