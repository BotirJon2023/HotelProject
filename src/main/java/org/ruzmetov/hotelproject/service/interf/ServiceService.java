package org.ruzmetov.hotelproject.service.interf;

import org.ruzmetov.hotelproject.dto.ServiceUpdateDto;
import org.ruzmetov.hotelproject.entity.Service;

public interface ServiceService {
    Service getServiceById(String id);

    Service createService(String service);

    Service updateServiceById(String id, ServiceUpdateDto serviceUpdateDto);

    Service deleteServiceById(String id);



}
