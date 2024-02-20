package org.ruzmetov.hotelproject.controller.rest;


import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.dto.RoomUpdateDto;
import org.ruzmetov.hotelproject.dto.ServiceDto;
import org.ruzmetov.hotelproject.dto.ServiceUpdateDto;
import org.ruzmetov.hotelproject.entity.Customer;
import org.ruzmetov.hotelproject.entity.Room;
import org.ruzmetov.hotelproject.entity.Service;
import org.ruzmetov.hotelproject.service.interf.ServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceService serviceService;

    @GetMapping("/{id}") // http://localhost:8080/service/5690a8ff-3007-4978-9d52-4c541da26e76
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Request for Service in the Hotel (optional)",
            description = "With exact id of Service we can see which types of Services are booked in the Hotel" +
                    " - than endpoint returns all Services.")
    @ApiResponse(responseCode = "200", description = "Successfully returned Services", content = {
            @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = ServiceDto.class)))
    })
    public Service getServiceByServiceId(@RequestParam(required = false) String service, @PathVariable String id) {
        return serviceService.getServiceById(id);
    }

//
//    public Service getServiceByServiceId(@PathVariable("id") String id) {
//        return serviceService.getServiceById(id);
//    }


    @PostMapping("/createOneService")  // http://localhost:8080/service/createOneService
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Request for creating new Service in the Hotel (optional)",
            description = "With exact id of Service we can create new types of Services" +
                    " - than endpoint returns all Services.")
    @ApiResponse(responseCode = "200", description = "Successfully created Service", content = {
            @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = ServiceDto.class)))
    })
    public Service postCreateService(@RequestParam(required = false) String service, @PathVariable String id) {
        return serviceService.createService(service);
    }

    @PutMapping("/updateOneService/{id}")
// http://localhost:8080/service/updateOneService/5690a8ff-3007-4978-9d52-4c541da26e76
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Request for updating the Service in the Hotel (optional)",
            description = "With exact id of Service we can update Services" +
                    " - than endpoint returns all Services.")
    @ApiResponse(responseCode = "200", description = "Successfully updated Service", content = {
            @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = ServiceDto.class)))
    })
    public Service updateServiceByServiceId(@PathVariable(value = "id") String id, @RequestBody ServiceUpdateDto serviceUpdateDto) {
        return serviceService.updateServiceById(id, serviceUpdateDto);
    }

    @DeleteMapping("/delete/{id}") // http://localhost:8080/service/delete/5690a8ff-3007-4978-9d52-4c541da26e76
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Request for deleting the Service in the Hotel (optional)",
            description = "With exact id of Service we can delete Services" +
                    " - than endpoint returns all Services.")
    @ApiResponse(responseCode = "200", description = "Successfully updated Service", content = {
            @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = ServiceDto.class)))
    })
    public Service deleteServiceByServiceId(@PathVariable("id") String id) {
        return serviceService.deleteServiceById(id);
    }
}
