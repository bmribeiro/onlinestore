package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlinestore.javarest.entities.AttributeType;
import com.onlinestore.javarest.entities.Product;
import com.onlinestore.javarest.entities.ProductCategory;
import com.onlinestore.javarest.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    
    @PostMapping
    public ResponseEntity<Product> createBrand(@RequestParam(name = "file") MultipartFile file,
            @RequestPart(name = "product") String productCategoryJson) throws JsonMappingException, JsonProcessingException {
    	
    	Product product = new ObjectMapper().readValue(productCategoryJson, Product.class);
    	
    	Product savedProduct = productService.addProduct(product, file);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
}