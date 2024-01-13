package org.ruzmetov.hotelproject.controller.page;

import org.ruzmetov.hotelproject.entity.Customer;
// import org.ruzmetov.hotelproject.entity.CustomerService;
import lombok.RequiredArgsConstructor;
// import org.ruzmetov.hotelproject.service.util.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor


public class CustomerController {

    // private final CustomerService customerService;

    @GetMapping("/{id}")
    public Customer getAccountById(@PathVariable("id") String id) {
        // return customerService.getAccountById(id);
        return null;
    }
}