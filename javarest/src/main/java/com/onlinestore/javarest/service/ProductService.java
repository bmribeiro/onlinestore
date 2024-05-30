package com.onlinestore.javarest.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.Product;
import com.onlinestore.javarest.entities.ProductImage;
import com.onlinestore.javarest.images.LocalImageFileService;
import com.onlinestore.javarest.repository.ProductCoverRepository;
import com.onlinestore.javarest.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductCoverRepository productCoverRepository;

	@Autowired
	private LocalImageFileService localImageFileService;

	public List<Product> getAllProducts() throws IOException {
		List<Product> products = (List<Product>) productRepository.findAll();
		
		for(Product el : products) {
			localImageFileService.getProductImages(el);
		}
		return products;
	}

	public List<Product> getProductsByCategory(int categoryId) throws IOException {
		List<Product> products = productRepository.getProductByCategory(Integer.valueOf(categoryId));

		for(Product el : products) {
			localImageFileService.getProductImages(el);
		}
		return products;
	}

	public Optional<Product> getProductById(Long productCategoryId) {
		return productRepository.findById(productCategoryId.intValue());
	}

	public Product addProduct(Product productEntity) {

		Product product = productRepository.save(productEntity);

		// Save each category image
		for (ProductImage image : product.getProductImages()) {
			image.setProduct(product);
			productCoverRepository.save(image);

			// Save Image Local
			localImageFileService.uploadProductImages(image);
		}
		return product;
	}

	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	@Transactional
	public void deleteProductById(Long productId) {
		productRepository.deleteById(productId.intValue());
	}

}
