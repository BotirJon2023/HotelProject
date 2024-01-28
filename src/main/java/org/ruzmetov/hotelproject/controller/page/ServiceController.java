package org.ruzmetov.hotelproject.controller.page;


import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.entity.Service;
import org.ruzmetov.hotelproject.service.interf.ServiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
@RequiredArgsConstructor

public class ServiceController {

    private final ServiceService serviceService;

    @GetMapping("/{id}")
    public Service getAccountById(@PathVariable("id") String id) {
        return serviceService.getAccById(id);

    }
}
