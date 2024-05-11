package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.ProductCategory;
import com.onlinestore.javarest.repository.ProductCategoryRepository;

@Service
public class ProductCategoryService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	public List<ProductCategory> getAllProductCategories() {
		return (List<ProductCategory>) productCategoryRepository.findAll();
	}

	public ProductCategory addProductCategory(ProductCategory productCategoryEntity) {
		return productCategoryRepository.save(productCategoryEntity);
	}
}