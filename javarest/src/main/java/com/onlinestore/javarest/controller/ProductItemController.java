package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlinestore.javarest.entities.ProductCategory;
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

	@PostMapping
    public ResponseEntity<ProductItem> createBrand(@RequestParam(name = "file") MultipartFile file,
            @RequestPart(name = "productCategory") String productCategoryJson) throws JsonMappingException, JsonProcessingException {
		
    	ProductItem productItem = new ObjectMapper().readValue(productCategoryJson, ProductItem.class);

    	ProductItem savedProductItem = productItemService.addProductItem(productItem, file);
    	
        return new ResponseEntity<>(savedProductItem, HttpStatus.CREATED);
    }
    
}