package org.ruzmetov.hotelproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.dto.ServiceUpdateDto;
import org.ruzmetov.hotelproject.entity.Service;
import org.ruzmetov.hotelproject.exception.ServiceNotFoundException;
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
    public Service createService(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public Service updateServiceById(String id, ServiceUpdateDto serviceUpdateDto) {
        Service service = serviceRepository.findById(UUID.fromString(id)).orElseThrow(() -> new ServiceNotFoundException("Service with this id not found!"));
        service.setRestaurantBooked(serviceUpdateDto.isBeakfastBooked());
        service.setServiceRestaurantPrice(serviceUpdateDto.getServiceRestaurantPrice());
        service.setBarBooked(serviceUpdateDto.isBarBooked());
        service.setServiceBarPrice(serviceUpdateDto.getServiceBarPrice());
        service.setSwimmingPoolBooked(serviceUpdateDto.isSwimmingPoolBooked());
        service.setServiceSwimmingPoolPrice(serviceUpdateDto.getServiceSwimmingPoolPrice());
        service.setIsGymBooked(serviceUpdateDto.isIsGymBooked());
        service.setServiceGymPrice(serviceUpdateDto.getServiceGymPrice());
        service.setGarageBooked(serviceUpdateDto.isGarageBooked());
        service.setServiceGaragePrice(serviceUpdateDto.getServiceGaragePrice());
        service.setAirportTransferBooked(serviceUpdateDto.isAirportTransferBooked());
        service.setServiceAirportTransferPrice(serviceUpdateDto.getServiceAirportTransferPrice());
        return serviceRepository.save(service);
    }

    @Override
    public final Service deleteServiceById(String id) {
        return serviceRepository.deleteServiceByServiceId(UUID.fromString(id));
    }
}
