package org.ruzmetov.hotelproject.repository;

import org.ruzmetov.hotelproject.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServiceRepository extends JpaRepository<Service, UUID> {

    Service findServiceByServiceId(UUID id);
    Service deleteServiceByServiceId(UUID id);

}
