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

import com.onlinestore.javarest.entities.Brand;
import com.onlinestore.javarest.service.BrandService;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }
    
    @GetMapping(path = "/{id}")
	public Optional<Brand> getBrandById(@PathVariable Long id) {
		return brandService.getBrandById(id);
	}
    
    @PostMapping
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
    	Brand savedBrand = brandService.addBrand(brand);
        return new ResponseEntity<>(savedBrand, HttpStatus.CREATED);
    }
    
    @PutMapping()
	public Brand updateBrand(@RequestBody Brand brand) {
		return brandService.updateBrand(brand);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteBrandById(@PathVariable Long id) {
		brandService.deleteBrandById(id);
		return ResponseEntity.ok().build();
	}
    
}