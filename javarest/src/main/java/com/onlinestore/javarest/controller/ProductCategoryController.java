package com.onlinestore.javarest.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlinestore.javarest.entities.ProductCategory;
import com.onlinestore.javarest.service.ProductCategoryService;

@RestController
@RequestMapping("/api/product-categories")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryService.getAllProductCategories();
    }
    
    @PostMapping()
    public ResponseEntity<ProductCategory> createProductCategory(
    		@RequestParam(name = "file") MultipartFile file,
            @RequestPart(name = "productCategory") String productCategoryJson) throws IOException {
    	
    	ProductCategory productCategory = new ObjectMapper().readValue(productCategoryJson, ProductCategory.class);
    	
    	ProductCategory savedProductCategory = productCategoryService.addProductCategory(productCategory, file);
    	
    	return new ResponseEntity<>(savedProductCategory, HttpStatus.CREATED);
    	
//    	
    }
    
}