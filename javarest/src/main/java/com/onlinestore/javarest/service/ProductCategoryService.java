package com.onlinestore.javarest.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.onlinestore.javarest.entities.ProductCategory;
import com.onlinestore.javarest.repository.ProductCategoryRepository;

@Service
public class ProductCategoryService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	public List<ProductCategory> getAllProductCategories() {
		return (List<ProductCategory>) productCategoryRepository.findAll();
	}

	public ProductCategory addProductCategory(ProductCategory productCategoryEntity, MultipartFile file) {

		ProductCategory productCategory = productCategoryRepository.save(productCategoryEntity);

		String projectPath = System.getProperty("user.dir");

		String categoryId = String.valueOf(productCategory.getProductCategoryId());
		
		Path imagesPath = Paths.get(projectPath, "images", categoryId);

		if (!Files.exists(imagesPath)) {
			try {
				Files.createDirectories(imagesPath);
				
				String fileName = file.getOriginalFilename();
				Path path = Paths.get(imagesPath + "/" + fileName);
				
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Falha ao criar a pasta: " + productCategory.getProductCategoryId().toString());
			}
		} else {
			System.out.println("A pasta já existe: " + productCategory.getProductCategoryId().toString());
		}

		return productCategory;
	}
}