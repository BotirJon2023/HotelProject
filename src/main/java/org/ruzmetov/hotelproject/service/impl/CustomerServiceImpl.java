package org.ruzmetov.hotelproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.entity.Customer;
import org.ruzmetov.hotelproject.repository.CustomerRepository;
import org.ruzmetov.hotelproject.service.interf.CustomerService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(String id) {

        return customerRepository.findCustomerByCustomerId(UUID.fromString(id));
    }
}

