package org.ruzmetov.hotelproject.controller.page;


import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.entity.Customer;
import org.ruzmetov.hotelproject.entity.Service;
import org.ruzmetov.hotelproject.service.interf.ServiceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceService serviceService;

    @GetMapping("/{id}") // http://localhost:8080/service/5690a8ff-3007-4978-9d52-4c541da26e76
    public Service getServiceByServiceId(@PathVariable("id") String id) {
        return serviceService.getServiceById(id);
    }

    @DeleteMapping("/delete/{id}") // http://localhost:8080/service/delete/5690a8ff-3007-4978-9d52-4c541da26e76
    public Service deleteServiceByServiceId(@PathVariable("id") String id) {
        return serviceService.deleteServiceById(id);
    }
}
