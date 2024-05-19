package com.onlinestore.javarest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.Brand;
import com.onlinestore.javarest.repository.BrandRepository;

import jakarta.transaction.Transactional;

@Service
public class BrandService {

	@Autowired
	private BrandRepository brandRepository;

	public List<Brand> getAllBrands() {
		return (List<Brand>) brandRepository.findAll();
	}

	public Optional<Brand> getBrandById(Long attributeOptionId) {
		return brandRepository.findById(attributeOptionId.intValue());
	}

	public Brand addBrand(Brand brandEntity) {
		return brandRepository.save(brandEntity);
	}

	public Brand updateBrand(Brand brandEntity) {
		return brandRepository.save(brandEntity);
	}

	@Transactional
	public void deleteBrandById(Long brandId) {
		brandRepository.deleteById(brandId.intValue());
	}
}