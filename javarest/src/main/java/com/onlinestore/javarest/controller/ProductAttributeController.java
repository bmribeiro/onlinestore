package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.ProductAttribute;
import com.onlinestore.javarest.service.ProductAttributeService;

@RestController
@RequestMapping("/api/product-attributes")
public class ProductAttributeController {

    @Autowired
    private ProductAttributeService productAttributeService;

    @GetMapping
    public List<ProductAttribute> getAllProductAttributes() {
        return productAttributeService.getAllProductAttributes();
    }

}