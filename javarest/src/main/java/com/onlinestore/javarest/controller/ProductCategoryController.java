package com.onlinestore.javarest.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlinestore.javarest.entities.ProductCategory;
import com.onlinestore.javarest.service.ProductCategoryService;

@RestController
@RequestMapping("/api/product-categories")
public class ProductCategoryController {

	@Autowired
	private ProductCategoryService productCategoryService;

	@GetMapping
	public List<ProductCategory> getAllProductCategories(@RequestParam(required = false) String parentProductCategory,
			@RequestParam(required = false) Integer parentProductCategoryId) throws IOException {

		List<ProductCategory> productsCategory = new ArrayList<ProductCategory>();

		// Parent
		if (parentProductCategory != null && parentProductCategory.equals("null")) {
			productsCategory = (List<ProductCategory>) productCategoryService.getProductCategoriesWithNullParent();
		}

		// Child's
		else if (parentProductCategoryId != null) {
			productsCategory = (List<ProductCategory>) productCategoryService
					.getProductCategoriesFromParent(parentProductCategoryId.longValue());
		}

		// All
		else {
			productsCategory = (List<ProductCategory>) productCategoryService.getAllProductCategories();
		}

		for (ProductCategory el : productsCategory) {

			if (el.getCategoryImage() != null) {

				String directoryPath = "C:/Users/Bruno/git/onlinestore/javarest/images";
				directoryPath = directoryPath + "/" + el.getProductCategoryId().toString() + "/"
						+ el.getCategoryImage();

				byte[] imageBytes = Files.readAllBytes(Paths.get(directoryPath));
				String imgEncodedString = Base64.getEncoder().encodeToString(imageBytes);
				el.setImageBytes(imgEncodedString);
			}
		}

		return productsCategory;
	}

	@GetMapping(path = "/{id}")
	public Optional<ProductCategory> getProductCategoryById(@PathVariable Long id) {
		return productCategoryService.getProductCategoryById(id);
	}

	@PostMapping()
	public ResponseEntity<ProductCategory> createProductCategory(
			@RequestParam(name = "file", required = false) MultipartFile file,
			@RequestPart(name = "productCategory") String productCategoryJson) throws IOException {

		ProductCategory productCategory = new ObjectMapper().readValue(productCategoryJson, ProductCategory.class);

		ProductCategory savedProductCategory = productCategoryService.addProductCategory(productCategory, file);

		return new ResponseEntity<>(savedProductCategory, HttpStatus.CREATED);

	}

	@PutMapping()
	public ProductCategory updateProductCategory(@RequestParam(name = "file", required = false) MultipartFile file,
			@RequestPart(name = "productCategory") String productCategoryJson) throws IOException {

		System.out.println("JAVA Controller: " + file);

		ProductCategory productCategory = new ObjectMapper().readValue(productCategoryJson, ProductCategory.class);

		return productCategoryService.updateProductCategory(productCategory, file);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteProductCategoryById(@PathVariable Long id) {
		productCategoryService.deleteProductCategoryById(id);
		return ResponseEntity.ok().build();
	}

}