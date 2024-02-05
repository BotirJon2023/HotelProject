package org.ruzmetov.hotelproject.controller.page;


import lombok.RequiredArgsConstructor;
import org.ruzmetov.hotelproject.dto.RoomUpdateDto;
import org.ruzmetov.hotelproject.dto.ServiceUpdateDto;
import org.ruzmetov.hotelproject.entity.Customer;
import org.ruzmetov.hotelproject.entity.Room;
import org.ruzmetov.hotelproject.entity.Service;
import org.ruzmetov.hotelproject.service.interf.ServiceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceService serviceService;

    @GetMapping("/{id}") // http://localhost:8080/service/5690a8ff-3007-4978-9d52-4c541da26e76
    public Service getServiceByServiceId(@PathVariable("id") String id) {
        return serviceService.getServiceById(id);
    }


    @PostMapping("/createOneService")  // http://localhost:8080/service/createOneService
    @ResponseBody
    public Service postCreateService(@RequestBody Service service) {
        return serviceService.createService(service);
    }

    @PutMapping("/updateOneService/{id}")
    // http://localhost:8080/service/updateOneService/5690a8ff-3007-4978-9d52-4c541da26e76
    public Service updateServiceByServiceId(@PathVariable(value = "id") String id, @RequestBody ServiceUpdateDto serviceUpdateDto) {
        return serviceService.updateServiceById(id, serviceUpdateDto);
    }

    @DeleteMapping("/delete/{id}") // http://localhost:8080/service/delete/5690a8ff-3007-4978-9d52-4c541da26e76
    public Service deleteServiceByServiceId(@PathVariable("id") String id) {
        return serviceService.deleteServiceById(id);
    }
}
