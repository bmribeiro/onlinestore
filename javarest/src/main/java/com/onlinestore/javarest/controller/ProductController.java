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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.Product;
import com.onlinestore.javarest.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> getAllProducts() throws IOException {
		return productService.getAllProducts();
	}

	@GetMapping(path = "/category/{categoryId}")
	public List<Product> getProductsByCategory(@PathVariable int categoryId) throws IOException {
		return productService.getProductsByCategory(categoryId);
	}

	@GetMapping(path = "/{id}")
	public Optional<Product> getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {

		Product savedProduct = productService.addProduct(product);
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}

	@PutMapping()
	public Product updateProduct(@RequestBody Product product) throws IOException {
		return productService.updateProduct(product);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
		productService.deleteProductById(id);
		return ResponseEntity.ok().build();
	}
}