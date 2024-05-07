package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.ProductVariation;
import com.onlinestore.javarest.repository.ProductVariationRepository;

@Service
public class ProductVariationService {

    @Autowired
    private ProductVariationRepository productVariationRepository;

    public List<ProductVariation> getAllProductVariations() {
        return (List<ProductVariation>) productVariationRepository.findAll();
    }
}