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

import com.onlinestore.javarest.entities.Product;
import com.onlinestore.javarest.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

	public Product addProduct(Product productEntity, MultipartFile file) {

		Product product = productRepository.save(productEntity);

		String projectPath = System.getProperty("user.dir");

		String categoryId = String.valueOf(product.getProductCategory().getProductCategoryId());
		String productId = String.valueOf(product.getProductId());

		Path imagesPath = Paths.get(projectPath, "images", categoryId, productId);

		if (!Files.exists(imagesPath)) {
			try {
				Files.createDirectories(imagesPath);

				String fileName = file.getOriginalFilename();
				Path path = Paths.get(imagesPath + "/" + fileName);

				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Falha ao criar a pasta: " + product.getProductId().toString());
			}
		} else {
			System.out.println("A pasta já existe: " + product.getProductId().toString());
		}
		return product;
	}
}
