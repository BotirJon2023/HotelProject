package org.ruzmetov.hotelproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ruzmetov.hotelproject.dto.CustomerDtoReservations;
import org.ruzmetov.hotelproject.dto.CustomerUpdateDto;
import org.ruzmetov.hotelproject.dto.ReservationDto;
import org.ruzmetov.hotelproject.entity.Customer;
import org.ruzmetov.hotelproject.exception.CustomerNotFoundException;
import org.ruzmetov.hotelproject.repository.CustomerRepository;
import org.ruzmetov.hotelproject.service.interf.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;


    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Customer getCustomerById(String id) {
        return customerRepository.findCustomerByCustomerId(UUID.fromString(id));
    }

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public CustomerDtoReservations getCustomerWithReservationByCustomerId(String id) {
        log.info("Find customer with reservation id {}.", id);
        Customer customer = customerRepository.findById(UUID.fromString(id)).orElseThrow(() -> new CustomerNotFoundException("Customer with this id not found!"));
        CustomerDtoReservations customerDtoReservations = new CustomerDtoReservations();
        customerDtoReservations.setFirstName(customer.getFirstName());
        customerDtoReservations.setReservations(customer.getReservations().stream().map(reservation -> new ReservationDto(reservation.getReservationId())).collect(Collectors.toSet()));
        return customerDtoReservations;
    }


    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Customer createCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Customer updateCustomerById(String id, CustomerUpdateDto customerUpdateDto) {
        log.info("Updated customer with id {} was called.", id);
        Customer customer = customerRepository.findById(UUID.fromString(id)).orElseThrow(() -> new CustomerNotFoundException("Customer with this id not found!"));
        customer.setFirstName(customerUpdateDto.getFirstName());
        customer.setLastName(customerUpdateDto.getLastName());
        customer.setEmail(customerUpdateDto.getEmail());
        customer.setAddress(customerUpdateDto.getAddress());
        customer.setPhoneNumber(customerUpdateDto.getPhoneNumber());
        return customerRepository.save(customer);
    }


//


//    @Override
//    @Transactional
//    public Customer putCustomerById(String id) {
//        getCustomerById(id);
//        return customerRepository.putUpdateCustomer(UUID.fromString(id));
//    }


//
//    @Override
//    public Customer updateCustomerById(String id) {
//        Customer customerRepository.save(new Customer);
//
//    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Customer deleteCustomerById(String id) {
        return customerRepository.deleteCustomerByCustomerId(UUID.fromString(id));
    }


//    Override
//    @Transactional(readOnly = true)
//    public PaymentsScheduleDto getCreditPaymentsSchedule(String creditId) {
//        log.info("Get Credit payment schedule by credit id = {}", creditId);
//        Credit credit = creditRepository.findById(UUID.fromString(creditId))
//                .orElseThrow(() -> new CreditNotFoundException(ErrorMessage.NO_CREDIT_WITH_ID));
//        return creditMapper.creditToPaymentScheduleDto(credit);
}
