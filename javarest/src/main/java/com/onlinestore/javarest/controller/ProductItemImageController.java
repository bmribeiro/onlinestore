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

import com.onlinestore.javarest.entities.ProductItemImage;
import com.onlinestore.javarest.service.ProductImageService;

@RestController
@RequestMapping("/api/product-item-images")
public class ProductItemImageController {

	@Autowired
	ProductImageService productImageService;

	@GetMapping
	public List<ProductItemImage> getAllProductItemImages() {
		return productImageService.getAllProductItemImages();
	}

	@GetMapping("/product-item/{productItemId}")
	public List<ProductItemImage> getProductImagesFromProductItem(@PathVariable int productItemId) throws IOException {
		return productImageService.getProductItemImagesFromProductItem(productItemId);
	}
}
