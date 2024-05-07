package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.PaymentType;
import com.onlinestore.javarest.service.PaymentTypeService;

@RestController
@RequestMapping("/api/payment-types")
public class PaymentTypeController {

    @Autowired
    private PaymentTypeService paymentTypeService;

    @GetMapping
    public List<PaymentType> getAllPaymentTypes() {
        return paymentTypeService.getAllPaymentTypes();
    }
}