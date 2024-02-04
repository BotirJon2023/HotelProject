package org.ruzmetov.hotelproject.service.interf;

import org.ruzmetov.hotelproject.entity.Service;

public interface ServiceService {
    Service getServiceById(String id);

    Service deleteServiceById(String id);
}
