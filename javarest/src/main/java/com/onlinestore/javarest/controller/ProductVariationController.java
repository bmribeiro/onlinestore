package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.ProductVariation;
import com.onlinestore.javarest.service.ProductVariationService;

@RestController
@RequestMapping("/api/product-variations")
public class ProductVariationController {

    @Autowired
    private ProductVariationService productVariationService;

    @GetMapping
    public List<ProductVariation> getAllProductVariations() {
        return productVariationService.getAllProductVariations();
    }
}