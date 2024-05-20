package com.onlinestore.javarest.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.ProductCategory;
import com.onlinestore.javarest.entities.ProductImage;
import com.onlinestore.javarest.service.ProductImageService;

@RestController
@RequestMapping("/api/product-images")
public class ProductImageController {

	@Autowired
	ProductImageService productImageService;

	@GetMapping
	public List<ProductImage> getAllProductImages() {
		return productImageService.getAllProductImages();
	}

	@GetMapping("/product-item/{productItemId}")
	public List<ProductImage> getProductImagesFromProductItem(@PathVariable int productItemId) throws IOException {
		List<ProductImage> images = productImageService.getProductImagesFromProductItem(productItemId);

		for (ProductImage el : images) {

			String categoryFolder = el.getProductItem().getProduct().getProductCategory().getProductCategoryId()
					.toString();
			String productFolder = el.getProductItem().getProduct().getProductId().toString();
			String itemFolder = el.getProductItem().getProductItemId().toString();

			String directoryPath = "C:/Users/Bruno/git/onlinestore/javarest/images";
			directoryPath = directoryPath + "/" + categoryFolder + "/"
					+ productFolder + "/" + itemFolder + "/" + el.getImageFilename() ;

			byte[] imageBytes = Files.readAllBytes(Paths.get(directoryPath));
			String imgEncodedString = Base64.getEncoder().encodeToString(imageBytes);
			el.setImageBytes(imgEncodedString);
		}
		return images;
	}
}
