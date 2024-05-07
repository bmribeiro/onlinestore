package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.ProductCover;
import com.onlinestore.javarest.service.ProductCoverService;

@RestController
@RequestMapping("/api/product-covers")
public class ProductCoverController {

    @Autowired
    private ProductCoverService productCoverService;

    @GetMapping
    public List<ProductCover> getAllProductCovers() {
        return productCoverService.getAllProductCovers();
    }
}
