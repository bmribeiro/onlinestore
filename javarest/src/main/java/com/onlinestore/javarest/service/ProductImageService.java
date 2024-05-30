package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.ProductItemImage;
import com.onlinestore.javarest.repository.ProductImageRepository;

@Service
public class ProductImageService {

	@Autowired
	ProductImageRepository productImageRepository;

	public List<ProductItemImage> getAllProductItemImages() {
        return (List<ProductItemImage>) productImageRepository.findAll();
    }
	
	public List<ProductItemImage> getProductItemImagesFromProductItem(int productItemId){
		return (List<ProductItemImage>) productImageRepository.getProductImagesByProductItem(Integer.valueOf(productItemId));
	}
	
}
