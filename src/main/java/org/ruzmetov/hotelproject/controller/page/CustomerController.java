package org.ruzmetov.hotelproject.controller.page;

import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.entity.Customer;
import org.ruzmetov.hotelproject.service.interf.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor


public class CustomerController {

    private final CustomerService customerService;


//    public CustomerController(CustomerService customerService) {
//        this.customerService = customerService;


    @GetMapping("/{id}") // http://localhost:8080/customer/020124cu-s001-001t-0o0-024cus01to02
    public Customer getAccountById(@PathVariable("id") String id) {
        return customerService.getAccById(id);

    }

//    public CustomerService getCustomerService() {
//         return customerService;
//    }
}
