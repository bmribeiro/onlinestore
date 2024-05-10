package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    @PostMapping
    public ResponseEntity<SizeCategory> createSizeCategory(@RequestBody SizeCategory sizeCategory) {
    	SizeCategory savedSizeCategory = sizeCategoryService.addSizeCategory(sizeCategory);
        return new ResponseEntity<>(savedSizeCategory, HttpStatus.CREATED);
    }
}