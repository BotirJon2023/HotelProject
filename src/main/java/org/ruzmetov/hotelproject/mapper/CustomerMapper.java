package org.ruzmetov.hotelproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.ruzmetov.hotelproject.dto.CustomerDto;
import org.ruzmetov.hotelproject.dto.CustomerTestDto;
import org.ruzmetov.hotelproject.dto.EventDto;
import org.ruzmetov.hotelproject.entity.Customer;
import org.ruzmetov.hotelproject.entity.Event;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

@Mapper(componentModel = "spring", injectionStrategy = CONSTRUCTOR,
        uses = {CustomerMapper.class, UuidMapper.class})
public interface CustomerMapper {

    CustomerDto toDTO(Customer customer);

    Customer toEntity(CustomerTestDto customerTestDto);


//    @Mapping(source = "customer.id", target = "customerId")
//   CustomerDto customerDto(Customer customer);
}