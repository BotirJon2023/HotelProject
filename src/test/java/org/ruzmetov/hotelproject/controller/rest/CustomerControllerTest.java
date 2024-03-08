package org.ruzmetov.hotelproject.controller.rest;

import jakarta.persistence.Column;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.ruzmetov.hotelproject.dto.CustomerDto;
import org.ruzmetov.hotelproject.entity.Customer;
import org.ruzmetov.hotelproject.exception.CustomerNotFoundException;
import org.ruzmetov.hotelproject.repository.CustomerRepository;
import org.ruzmetov.hotelproject.service.interf.CustomerService;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
    CustomerRepository customerRepository;
    CustomerService customerService;

    void init() {
        customerService = new CustomerService(customerRepository);
    }


    @Test
    void getCustomerByCustomerId_ShouldReturnACustomer() {
        UUID id = UUID;
        Customer customer = new Customer(id, "firstName", "lastName", "email", "phoneNumber", "address", "loyalityPoints", "creditCardNumber", "creditCardExpiringDate");
        CustomerDto dto = new CustomerDto(customer.getCustomerId(), customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPhoneNumber(), customer.getAddress(), customer.getLoyalityPoints(), customer.getCreditCardNumber(), customer.getCreditCardExpiringDate());
        when(customerRepository.findCustomerByCustomerId()).thenReturn(Optional.of(customer));
        var result = customerService.getCustomerById(id);
        assertThat(result).isNotNull().isEqualTo(dto);
    }

    @Test
    void getCustomerByCustomerId_ShouldThrowException() {
        UUID id = UUID;
        when(customerRepository.findCustomerByCustomerId()).thenReturn(Optional.empty());
        assertThrows(CustomerNotFoundException.class, ()-> customerService.getCustomerById(id));
    }


    @Test
    void getCustomerWithReservationByCustomerId() {
    }

    @Test
    void postCreateCustomer() {
    }

    @Test
    void updateCustomerByCustomerId() {
    }

    @Test
    void deleteCustomerByCustomerId() {
    }
}