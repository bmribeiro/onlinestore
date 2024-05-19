package com.onlinestore.javarest.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.onlinestore.javarest.entities.ProductCategory;
import com.onlinestore.javarest.repository.ProductCategoryRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class ProductCategoryService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@PersistenceContext
	private EntityManager entityManager;

	public List<ProductCategory> getAllProductCategories() {
		return (List<ProductCategory>) productCategoryRepository.findAll();
	}

	public List<ProductCategory> getProductCategoriesWithNullParent() {
		return productCategoryRepository.getProductCategoriesWithNullParent();
	}

	public List<ProductCategory> getProductCategoriesFromParent(long parentProductCategoryId) {
		return productCategoryRepository.getProductCategoriesFromParent(parentProductCategoryId);
	}

	public Optional<ProductCategory> getProductCategoryById(Long productCategoryId) {
		return productCategoryRepository.findById(productCategoryId.intValue());
	}

	public ProductCategory addProductCategory(ProductCategory productCategoryEntity, MultipartFile file) {

		if (!file.equals(null)) {
			productCategoryEntity.setCategoryImage(file.getOriginalFilename());
		}

		ProductCategory productCategory = productCategoryRepository.save(productCategoryEntity);
		
		if (!file.equals(null)) {
			uploadFile(productCategory.getProductCategoryId().toString(), file);
		}
		
		return productCategory;
	}

	public ProductCategory updateProductCategory(ProductCategory productCategory, MultipartFile file) {

		if (!file.equals(null)) {
			productCategory.setCategoryImage(file.getOriginalFilename());
			uploadFile(productCategory.getProductCategoryId().toString(), file);
		}
		return productCategoryRepository.save(productCategory);
	}

	@Transactional
	public void deleteProductCategoryById(Long productCategoryId) {
		productCategoryRepository.deleteById(productCategoryId.intValue());
	}

	// Upload File
	private void uploadFile(String folderProductCategoryId, MultipartFile file) {

		String projectPath = System.getProperty("user.dir");

		Path imagesPath = Paths.get(projectPath, "images", folderProductCategoryId);

		if (!Files.exists(imagesPath)) {
			try {
				Files.createDirectories(imagesPath);

				String fileName = file.getOriginalFilename();
				Path path = Paths.get(imagesPath + "/" + fileName);

				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Falha ao criar a pasta: " + folderProductCategoryId);
			}
		} else {
			System.out.println("A pasta já existe: " + folderProductCategoryId);
		}
	}

}