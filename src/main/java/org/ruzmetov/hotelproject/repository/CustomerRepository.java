package org.ruzmetov.hotelproject.repository;

import org.ruzmetov.hotelproject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    Customer findCustomerByCustomerId(UUID id);

//    @Modifying
//    @Query("update Customer c set c.customerId = :customerId where c.customerId = :uuid")
//    Customer putUpdateCustomer(UUID id);

//    Customer putUpdateCustomer(UUID id);

    Customer deleteCustomerByCustomerId(UUID id);
}
