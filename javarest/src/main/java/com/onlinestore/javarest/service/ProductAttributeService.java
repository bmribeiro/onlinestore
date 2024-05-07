package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.ProductAttribute;
import com.onlinestore.javarest.repository.ProductAttributeRepository;

@Service
public class ProductAttributeService {

    @Autowired
    private ProductAttributeRepository productAttributeRepository;

    public List<ProductAttribute> getAllProductAttributes() {
        return (List<ProductAttribute>) productAttributeRepository.findAll();
    }

}