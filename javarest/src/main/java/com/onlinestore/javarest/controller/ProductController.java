package com.onlinestore.javarest.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlinestore.javarest.entities.Product;
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
    
    @GetMapping(path = "/category/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable int categoryId) {
        return productService.getProductsByCategory(categoryId);
    }
    
    @GetMapping(path = "/{id}")
	public Optional<Product> getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
    
    @PostMapping
    public ResponseEntity<Product> createProduct(
    		@RequestParam(name = "file") MultipartFile file,
            @RequestPart(name = "product") String productCategoryJson) throws JsonMappingException, JsonProcessingException {
    	
    	Product product = new ObjectMapper().readValue(productCategoryJson, Product.class);
    	
    	Product savedProduct = productService.addProduct(product, file);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
    
    @PutMapping()
	public Product updateProduct(@RequestParam(name = "file", required = false) MultipartFile file,
			@RequestPart(name = "product") String productJson) throws IOException {

		Product product = new ObjectMapper().readValue(productJson, Product.class);
		return productService.updateProduct(product, file);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
		productService.deleteProductById(id);
		return ResponseEntity.ok().build();
	}
}