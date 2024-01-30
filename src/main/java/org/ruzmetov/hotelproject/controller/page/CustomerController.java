package org.ruzmetov.hotelproject.controller.page;

import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.entity.Customer;
import org.ruzmetov.hotelproject.service.interf.CustomerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor


public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}") // http://localhost:8080/customer/5147b945-14c8-4f6f-8662-e8c3befb7838
    public Customer getCustomerByCustomerId(@PathVariable("id") String id) {
        return customerService.getCustomerById(id);
    }



}
