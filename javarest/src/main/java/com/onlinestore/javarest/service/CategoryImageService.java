package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.CategoryImage;
import com.onlinestore.javarest.repository.CategoryImageRepository;

@Service
public class CategoryImageService {
	
	@Autowired
	CategoryImageRepository categoryImageRepository;

	public List<CategoryImage> getAllCategoryImages() {
		return (List<CategoryImage>) categoryImageRepository.findAll();
	}
	
	public CategoryImage addCategoryImage(CategoryImage categoryImage) {
        return categoryImageRepository.save(categoryImage);
    }
	

}
