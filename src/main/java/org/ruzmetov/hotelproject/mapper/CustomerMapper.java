package org.ruzmetov.hotelproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.ruzmetov.hotelproject.dto.CustomerDto;
import org.ruzmetov.hotelproject.entity.Customer;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

@Mapper(componentModel = "spring", injectionStrategy = CONSTRUCTOR,
        uses = {CustomerMapper.class, UuidMapper.class})
public interface CustomerMapper {

//    @Mapping(source = "customer.id", target = "customerId")
//   CustomerDto customerDto(Customer customer);
}