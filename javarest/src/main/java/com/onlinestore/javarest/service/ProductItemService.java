package com.onlinestore.javarest.service;

import java.io.File;
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

import com.onlinestore.javarest.entities.AttributeOption;
import com.onlinestore.javarest.entities.ProductItem;
import com.onlinestore.javarest.repository.ProductItemRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductItemService {

	@Autowired
	private ProductItemRepository productItemRepository;

	public List<ProductItem> getAllProductItems() {
		return (List<ProductItem>) productItemRepository.findAll();
	}

	public Optional<ProductItem> getProductItemById(Long productItemId) {
		return productItemRepository.findById(productItemId.intValue());
	}

	public ProductItem addProductItem(ProductItem productItemEntity, MultipartFile file) {

		ProductItem productItem = productItemRepository.save(productItemEntity);

		String projectPath = System.getProperty("user.dir");

		String categoryId = String.valueOf(productItemEntity.getProduct().getProductCategory().getProductCategoryId());
		String productId = String.valueOf(productItemEntity.getProduct().getProductId());
		String itemId = String.valueOf(productItem.getProductItemId());

		Path imagesPath = Paths.get(projectPath, "images", categoryId, productId, itemId);

		if (!Files.exists(imagesPath)) {
			try {

				Files.createDirectories(imagesPath);

				String fileName = file.getOriginalFilename();
				Path path = Paths.get(imagesPath + "/" + fileName);

				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Falha ao criar a pasta: " + itemId);
			}
		} else {
			System.out.println("A pasta já existe: " + itemId);
		}
		return productItem;
	}

	public ProductItem updateProductItem(ProductItem productItemEntity, MultipartFile file) {
		
		if (!file.equals(null)) {
			uploadFile(productItemEntity.getProduct().getProductCategory().getProductCategoryId().toString(),
					productItemEntity.getProduct().getProductId().toString(),
					productItemEntity.getProductItemId().toString(), file);
		}
		
		return productItemRepository.save(productItemEntity);
	}

	@Transactional
	public void deleteProductItemById(Long attributeOptionId) {
		productItemRepository.deleteById(attributeOptionId.intValue());
	}

	// Upload File
	private void uploadFile(String folderProductCategory, String folderProduct, String folderProductItem,
			MultipartFile file) {

		System.out.println("Caterogy: " + folderProductCategory);
		System.out.println("Product: " + folderProduct);
		System.out.println("Item: " + folderProductItem);

		String projectPath = System.getProperty("user.dir");

		Path imagesPath = Paths.get(projectPath, "images",
				folderProductCategory + "//" + folderProduct + "//" + folderProductItem);
		System.out.println("Path: " + imagesPath);

		if (!Files.exists(imagesPath)) {
			try {
				Files.createDirectories(imagesPath);

				String fileName = file.getOriginalFilename();
				Path path = Paths.get(imagesPath + "/" + fileName);

				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Falha ao criar a pasta: " + folderProductCategory);
			}
		} else {
			System.out.println("A pasta já existe: " + folderProduct);
		}
	}
}