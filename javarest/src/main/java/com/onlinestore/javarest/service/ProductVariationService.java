package com.onlinestore.javarest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.ProductVariation;
import com.onlinestore.javarest.repository.ProductVariationRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductVariationService {

    @Autowired
    private ProductVariationRepository productVariationRepository;

    public List<ProductVariation> getAllProductVariations() {
        return (List<ProductVariation>) productVariationRepository.findAll();
    }
    
    public List<ProductVariation> getProductVariationByProductItem(int productItemId) {
    	return (List<ProductVariation>) productVariationRepository.getProductVariationsByProductItem(Integer.valueOf(productItemId));
	}
    
    public Optional<ProductVariation> getProductVariationById(Long attributeOptionId) {
		return productVariationRepository.findById(attributeOptionId.intValue());
	}

	public ProductVariation addProductVariation(ProductVariation productVariationEntity) {
		return productVariationRepository.save(productVariationEntity);
	}

	public ProductVariation updateProductVariation(ProductVariation productVariationEntity) {
		return productVariationRepository.save(productVariationEntity);
	}

	@Transactional
	public void deleteProductVariationById(Long attributeOptionId) {
		productVariationRepository.deleteById(attributeOptionId.intValue());
	}

	
}