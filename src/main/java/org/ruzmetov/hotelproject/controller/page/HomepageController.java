package org.ruzmetov.hotelproject.controller.page;

import org.ruzmetov.hotelproject.service.interf.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {

    @GetMapping("/pages") //  http://localhost:8080/customer/pages
    public String homepage() {
        return "index";
    }

    // http://localhost:8080/swagger-ui/index.html

}
