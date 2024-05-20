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
import com.onlinestore.javarest.entities.Colour;
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

	@GetMapping(path = "/product/{productId}")
	public List<ProductItem> getProductItemsByProduct(@PathVariable int productId) {
		return productItemService.getProductItemsByProduct(productId);
	}

	@GetMapping("/product/{productId}/colours")
	public List<Colour> findColoursByProducItemtId(@PathVariable int productId) {
		return productItemService.findColoursByProducItemtId(productId);
	}

	@GetMapping(path = "/{id}")
	public Optional<ProductItem> getProductItemById(@PathVariable Long id) {
		return productItemService.getProductItemById(id);
	}

	@PostMapping
	public ResponseEntity<ProductItem> createProductItem(@RequestParam(name = "file") MultipartFile file,
			@RequestPart(name = "productItem") String productCategoryJson)
			throws JsonMappingException, JsonProcessingException {

		ProductItem productItem = new ObjectMapper().readValue(productCategoryJson, ProductItem.class);

		ProductItem savedProductItem = productItemService.addProductItem(productItem, file);

		return new ResponseEntity<>(savedProductItem, HttpStatus.CREATED);
	}

	@PutMapping()
	public ProductItem updateProductItem(@RequestParam(name = "file", required = false) MultipartFile file,
			@RequestPart(name = "productItem") String productItemJson) throws IOException {

		ProductItem productItem = new ObjectMapper().readValue(productItemJson, ProductItem.class);
		return productItemService.updateProductItem(productItem, file);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteProductItemById(@PathVariable Long id) {
		productItemService.deleteProductItemById(id);
		return ResponseEntity.ok().build();
	}

}