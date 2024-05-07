package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.UserPaymentPhone;
import com.onlinestore.javarest.service.UserPaymentPhoneService;

@RestController
@RequestMapping("/api/user-payment-phones")
public class UserPaymentPhoneController {

    @Autowired
    private UserPaymentPhoneService userPaymentPhoneService;

    @GetMapping
    public List<UserPaymentPhone> getAllUserPaymentPhones() {
        return userPaymentPhoneService.getAllUserPaymentPhones();
    }

}
