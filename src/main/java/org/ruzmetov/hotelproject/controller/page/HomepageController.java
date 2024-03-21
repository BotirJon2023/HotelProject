package org.ruzmetov.hotelproject.controller.page;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.ruzmetov.hotelproject.service.interf.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
public class HomepageController {

    @GetMapping("/pages") //  http://localhost:8080/pages
    // http://localhost:8080/swagger-ui/index.html
    public String homepage() {

        return "index";
    }

    @GetMapping("/page_for_users") //  http://localhost:8080/page_for_users
    public String pageForUsers() {
        return "PAGE FOR USERS";
    }

    @GetMapping("/page_for_admins") //  http://localhost:8080/page_for_admins
    public String pageForAdmins() {
        return "PAGE FOR ADMINS";
    }

    @GetMapping("/read_secret") //  http://localhost:8080/read_secret
    public String readSecret(HttpServletRequest request) {
        handleRequest(request);
        return "READ SECRET";
    }

    private void handleRequest(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("JSESSIONID".equals(c.getName())) {
                    System.out.println("JSESSIONID: " + c.getValue());
                }
            }
        }

    }


}
