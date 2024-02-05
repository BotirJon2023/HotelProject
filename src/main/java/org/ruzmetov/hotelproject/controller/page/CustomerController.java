package org.ruzmetov.hotelproject.controller.page;

import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.dto.CustomerDtoReservations;
import org.ruzmetov.hotelproject.dto.CustomerUpdateDto;
import org.ruzmetov.hotelproject.entity.Customer;
import org.ruzmetov.hotelproject.service.interf.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping("/{id}") // http://localhost:8080/customer/5147b945-14c8-4f6f-8662-e8c3befb7838
    public Customer getCustomerByCustomerId(@PathVariable("id") String id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/reservation/{id}") // http://localhost:8080/customer/reservation/5147b945-14c8-4f6f-8662-e8c3befb7838
    public CustomerDtoReservations getCustomerWithReservationByCustomerId(@PathVariable("id") String id) {
        return customerService.getCustomerWithReservationByCustomerId(id);
    }

    @PostMapping("/createOneCustomer")  // http://localhost:8080/customer/createOneCustomer
    @ResponseBody
    public Customer postCreateCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping("/updateOneCustomer/{id}")
    // http://localhost:8080/customer/updateOneCustomer/5147b945-14c8-4f6f-8662-e8c3befb7838
    public Customer updateCustomerByCustomerId(@PathVariable(value = "id") String id, @RequestBody CustomerUpdateDto customerUpdateDto) {
        return customerService.updateCustomerById(id, customerUpdateDto);
    }

    @DeleteMapping("/delete/{id}") // http://localhost:8080/customer/delete/5147b945-14c8-4f6f-8662-e8c3befb7838
    public Customer deleteCustomerByCustomerId(@PathVariable("id") String id) {
        return customerService.deleteCustomerById(id);
    }
}
