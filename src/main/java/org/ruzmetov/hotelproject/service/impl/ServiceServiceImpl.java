package org.ruzmetov.hotelproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.entity.Service;
import org.ruzmetov.hotelproject.repository.ServiceRepository;
import org.ruzmetov.hotelproject.service.interf.ServiceService;

import java.util.UUID;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    @Override
    public Service getServiceById(String id) {
        return serviceRepository.findServiceByServiceId(UUID.fromString(id));
    }

    @Override
    public final Service deleteServiceById(String id) {
        return serviceRepository.deleteServiceByServiceId(UUID.fromString(id));
    }
}
