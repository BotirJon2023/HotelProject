package org.ruzmetov.hotelproject.controller.page;

import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.dto.CustomerDto;
import org.ruzmetov.hotelproject.entity.Customer;
import org.ruzmetov.hotelproject.service.interf.CustomerService;
import org.springframework.validation.annotation.Validated;
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

    @PostMapping("/createOneCustomer")  // http://localhost:8080/createOneCustomer
    @ResponseBody
    public Customer postCreateCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

//    @PutMapping("/updateOneCustomer/{id}")  // http://localhost:8080/createOneCustomer/5147b945-14c8-4f6f-8662-e8c3befb7838
//    public Customer putUpdateCustomer(@PathVariable(value = "id") String id) {
//        return customerService.putCustomerById(id);
//    }


//    @PutMapping("/updateOneCustomer/{id}") // http://localhost:8080/createOneCustomer/5147b945-14c8-4f6f-8662-e8c3befb7838
//    public Customer updateCustomerByCustomerId(@PathVariable UUID id, @RequestBody Customer updatedCustomer) {
//        Customer customer = customerService.getCustomerById(String.valueOf(id));
//        if (customer != null) {
//            updatedCustomer.setCustomerId(id);
//                customerService.updateCustomerById(String.valueOf(id));
//            return new Customer(updatedCustomer, HttpStatus.OK);
//        } else {
//            return new Customer(HcttpStatus.NOT_FOUND);
//        }
//    }


    @DeleteMapping("/delete/{id}") // http://localhost:8080/customer/delete/5147b945-14c8-4f6f-8662-e8c3befb7838
    public Customer deleteCustomerByCustomerId(@PathVariable("id") String id) {
        return customerService.deleteCustomerById(id);
    }
}
