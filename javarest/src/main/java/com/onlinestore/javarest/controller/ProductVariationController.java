package com.onlinestore.javarest.controller;

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

	@GetMapping(path = "/{id}")
	public Optional<ProductVariation> getProductVariationById(@PathVariable Long id) {
		return productVariationService.getProductVariationById(id);
	}

	@PostMapping
	public ResponseEntity<ProductVariation> createProductVariation(@RequestBody ProductVariation attributeOption) {
		ProductVariation savedProductVariation = productVariationService.addProductVariation(attributeOption);
		return new ResponseEntity<>(savedProductVariation, HttpStatus.CREATED);
	}

	@PutMapping()
	public ProductVariation updateProductVariation(@RequestBody ProductVariation productVariation) {
		return productVariationService.updateProductVariation(productVariation);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteProductVariationById(@PathVariable Long id) {
		productVariationService.deleteProductVariationById(id);
		return ResponseEntity.ok().build();
	}
}