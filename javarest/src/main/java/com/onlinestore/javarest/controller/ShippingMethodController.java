package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.ShippingMethod;
import com.onlinestore.javarest.service.ShippingMethodService;

@RestController
@RequestMapping("/api/shipping-methods")
public class ShippingMethodController {

    @Autowired
    private ShippingMethodService shippingMethodService;

    @GetMapping
    public List<ShippingMethod> getAllShippingMethods() {
        return shippingMethodService.getAllShippingMethods();
    }

}