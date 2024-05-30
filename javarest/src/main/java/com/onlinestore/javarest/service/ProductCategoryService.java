package com.onlinestore.javarest.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.onlinestore.javarest.entities.CategoryImage;
import com.onlinestore.javarest.entities.ProductCategory;
import com.onlinestore.javarest.images.LocalImageFileService;
import com.onlinestore.javarest.repository.CategoryImageRepository;
import com.onlinestore.javarest.repository.ProductCategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductCategoryService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Autowired
	private CategoryImageRepository categoryImageRepository;

	@Autowired
	private LocalImageFileService localImageFileService;

	public List<ProductCategory> getAllProductCategories() {
		return (List<ProductCategory>) productCategoryRepository.findAll();
	}

	public List<ProductCategory> getProductCategoriesWithNullParent() throws IOException {
		List<ProductCategory> productCategories = productCategoryRepository.getProductCategoriesWithNullParent();

		for (ProductCategory el : productCategories) {
			if (!el.getCategoryImages().isEmpty()) {
				localImageFileService.getCaterogyImages(el);
			}
		}
		return productCategories;
	}

	public List<ProductCategory> getProductCategoriesFromParent(long parentProductCategoryId) throws IOException {
		List<ProductCategory> productCategories = productCategoryRepository
				.getProductCategoriesFromParent(parentProductCategoryId);

		for (ProductCategory el : productCategories) {
			if (!el.getCategoryImages().isEmpty()) {
				localImageFileService.getCaterogyImages(el);
			}
		}
		return productCategories;
	}

	public Optional<ProductCategory> getProductCategoryById(Long productCategoryId) throws IOException {
		Optional<ProductCategory> productCategories = productCategoryRepository.findById(productCategoryId.intValue());
		localImageFileService.getCaterogyImages(productCategories.get());
		return productCategories;
	}

	public ProductCategory addProductCategory(ProductCategory productCategoryEntity) {

		ProductCategory productCategory = productCategoryRepository.save(productCategoryEntity);

		// Save each category image
		for (CategoryImage image : productCategory.getCategoryImages()) {
			image.setProductCategory(productCategory);
			categoryImageRepository.save(image);

			// Save Image Local
			localImageFileService.uploadCategoryImages(image);
		}
		return productCategory;
	}

	public ProductCategory updateProductCategory(ProductCategory productCategory, MultipartFile file) {
		return productCategoryRepository.save(productCategory);
	}

	@Transactional
	public void deleteProductCategoryById(Long productCategoryId) {
		productCategoryRepository.deleteById(productCategoryId.intValue());
	}
}