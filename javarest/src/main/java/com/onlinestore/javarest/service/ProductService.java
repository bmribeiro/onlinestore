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

import com.onlinestore.javarest.entities.Product;
import com.onlinestore.javarest.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

	public Optional<Product> getProductById(Long productCategoryId) {
		return productRepository.findById(productCategoryId.intValue());
	}

	public Product addProduct(Product productEntity, MultipartFile file) {

		Product product = productRepository.save(productEntity);

		if (!file.equals(null)) {
			uploadFile(productEntity.getProductCategory().getProductCategoryId().toString(),
					productEntity.getProductId().toString(), file);
		}
		return product;
	}

	public Product updateProduct(Product product, MultipartFile file) {

		if (!file.equals(null)) {
			uploadFile(product.getProductCategory().getProductCategoryId().toString(),
					product.getProductId().toString(), file);
		}
		return productRepository.save(product);
	}

	@Transactional
	public void deleteProductById(Long productId) {
		productRepository.deleteById(productId.intValue());
	}

	// Upload File
	private void uploadFile(String folderProductCategory, String folderProduct, MultipartFile file) {

		System.out.println("Caterogy: " + folderProductCategory);
		System.out.println("Product: " + folderProduct);

		String projectPath = System.getProperty("user.dir");

		Path imagesPath = Paths.get(projectPath, "images", folderProductCategory + "//" + folderProduct);
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
