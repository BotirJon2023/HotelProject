package org.ruzmetov.hotelproject.service.interf;

import org.ruzmetov.hotelproject.dto.CustomerDtoReservations;
import org.ruzmetov.hotelproject.dto.CustomerUpdateDto;
import org.ruzmetov.hotelproject.entity.Customer;

public interface CustomerService {

    Customer getCustomerById(String id);

    Customer createCustomer(Customer customer);

//    Customer putCustomerById(String id);

 //   Customer updateCustomerById(String id);

    Customer deleteCustomerById(String id);

    Customer updateCustomerById(String id, CustomerUpdateDto customerUpdateDto);

    CustomerDtoReservations getCustomerWithReservationByCustomerId(String id);
}
