package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.ProductItem;
import com.onlinestore.javarest.service.ProductItemService;

@RestController
@RequestMapping("/api/product-items")
public class ProductItemController {	

    @Autowired
    private ProductItemService productItemService;

    @GetMapping
    public List<ProductItem> getAllProductItems() {
        return productItemService.getAllProductItems();
    }
}