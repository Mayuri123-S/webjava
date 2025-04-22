package com.sunbeam.controllers;

import com.sunbeam.daos.CustomerDao;
import com.sunbeam.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomerController {
    @Autowired
    private CustomerDao customerDao;

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpServletRequest request) {
        Customer cust = customerDao.findByEmailAndPassword(email, password);
        if (cust != null) {
            request.setAttribute("msg", "Welcome " + cust.getName());
        } else {
            request.setAttribute("msg", "Login Failed");
        }
        return "welcome";
    }
}
