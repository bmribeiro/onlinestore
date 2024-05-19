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

import com.onlinestore.javarest.entities.SizeCategory;
import com.onlinestore.javarest.service.SizeCategoryService;

@RestController
@RequestMapping("/api/size-categories")
public class SizeCategoryController {

	@Autowired
	private SizeCategoryService sizeCategoryService;

	@GetMapping
	public List<SizeCategory> getAllSizeCategories() {
		return sizeCategoryService.getAllSizeCategories();
	}

	@GetMapping(path = "/{id}")
	public Optional<SizeCategory> getSizeOptionById(@PathVariable Long id) {
		return sizeCategoryService.getSizeCategoryById(id);
	}

	@PostMapping
	public ResponseEntity<SizeCategory> createSizeCategory(@RequestBody SizeCategory sizeCategory) {
		SizeCategory savedSizeCategory = sizeCategoryService.addSizeCategory(sizeCategory);
		return new ResponseEntity<>(savedSizeCategory, HttpStatus.CREATED);
	}

	@PutMapping()
	public SizeCategory updateSizeCategory(@RequestBody SizeCategory sizeOption) {
		return sizeCategoryService.updateSizeCategory(sizeOption);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteSizeCategoryById(@PathVariable Long id) {
		sizeCategoryService.deleteSizeCategoryById(id);
		return ResponseEntity.ok().build();
	}
}