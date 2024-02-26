package org.ruzmetov.hotelproject.controller.rest;


import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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
// @Tag()
@RestController
@RequestMapping("/service")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceService serviceService;

    @GetMapping("/{id}") // http://localhost:8080/service/5690a8ff-3007-4978-9d52-4c541da26e76
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Request for Service in the Hotel (optional)",
            description = "With exact id of Service we can see which types of Services are booked in the Hotel" +
                    " - than endpoint returns all Services.",
            //tags = "Service",
            externalDocs = @ExternalDocumentation(
                    description = "Here you find all necessary documentation",
                    url = "https://google.com"
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully returned Services"),
                    @ApiResponse(responseCode = "404", description = "Not returned Services")
            },
            security = {
                    @SecurityRequirement(name = "Security requirement")
            },
            hidden = false
    )
    public Service getServiceByServiceId(@RequestParam(required = false) String service, @PathVariable String id) {
        return serviceService.getServiceById(id);
    }

//
//    public Service getServiceByServiceId(@PathVariable("id") String id) {
//        return serviceService.getServiceById(id);
//    }


    @PostMapping("/createOneService")  // http://localhost:8080/service/createOneService
    //@ResponseBody
    @Operation(summary = "Request for creating new Service in the Hotel (optional)",
            description = "With exact id of Service we can add new Services in the Hotel" +
                    " - than endpoint returns all Services.",
           // tags = "Service",
            externalDocs = @ExternalDocumentation(
                    description = "Here you find all necessary documentation",
                    url = "https://google.com"
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully created Services"),
                    @ApiResponse(responseCode = "404", description = "Not created Services")
            },
            security = {
                    @SecurityRequirement(name = "Security requirement")
            },
            hidden = false
    )
    public Service postCreateService(@RequestBody Service service)
            //@RequestParam(required = false) String service, @PathVariable String id
             {
                 return serviceService.createService(service);
    }

    @PutMapping("/updateOneService/{id}")
// http://localhost:8080/service/updateOneService/5690a8ff-3007-4978-9d52-4c541da26e76
    @Operation(summary = "Updating the Service in the Hotel (optional)",
            description = "With exact id of Service we can update the Services in the Hotel" +
                    " - than endpoint returns all Services.",
           // tags = "Service",
            externalDocs = @ExternalDocumentation(
                    description = "Here you find all necessary documentation",
                    url = "https://google.com"
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully updated Services"),
                    @ApiResponse(responseCode = "404", description = "Not updated Services")
            },
            security = {
                    @SecurityRequirement(name = "Security requirement")
            },
            hidden = false
    )
    public Service updateServiceByServiceId(@PathVariable(value = "id") String id, @RequestBody ServiceUpdateDto serviceUpdateDto) {
        return serviceService.updateServiceById(id, serviceUpdateDto);
    }

    @DeleteMapping("/delete/{id}") // http://localhost:8080/service/delete/5690a8ff-3007-4978-9d52-4c541da26e76
    @Operation(summary = "Request for delete Service in the Hotel (optional)",
            description = "With exact id of Service we can delete the Service in the Hotel" +
                    " - than endpoint returns all Services.",
           // tags = "Service",
            externalDocs = @ExternalDocumentation(
                    description = "Here you find all necessary documentation",
                    url = "https://google.com"
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully deleted Service"),
                    @ApiResponse(responseCode = "404", description = "Not deleted Service")
            },
            security = {
                    @SecurityRequirement(name = "Security requirement")
            },
            hidden = false
    )
    public Service deleteServiceByServiceId(@PathVariable("id") String id) {
        return serviceService.deleteServiceById(id);
    }
}
