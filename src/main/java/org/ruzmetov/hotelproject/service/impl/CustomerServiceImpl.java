package org.ruzmetov.hotelproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.entity.Customer;
import org.ruzmetov.hotelproject.repository.CustomerRepository;
import org.ruzmetov.hotelproject.service.interf.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

import static com.ctc.wstx.shaded.msv_core.datatype.xsd.NumberType.save;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
//    private final CustomerMapper customerMapper;


    @Override
    public Customer getCustomerById(String id) {
        return customerRepository.findCustomerByCustomerId(UUID.fromString(id));
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }



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
    public Customer deleteCustomerById(String id) {
        return customerRepository.deleteCustomerByCustomerId(UUID.fromString(id));
    }
}

//    Override
//    @Transactional(readOnly = true)
//    public PaymentsScheduleDto getCreditPaymentsSchedule(String creditId) {
//        log.info("Get Credit payment schedule by credit id = {}", creditId);
//        Credit credit = creditRepository.findById(UUID.fromString(creditId))
//                .orElseThrow(() -> new CreditNotFoundException(ErrorMessage.NO_CREDIT_WITH_ID));
//        return creditMapper.creditToPaymentScheduleDto(credit);
//    }
