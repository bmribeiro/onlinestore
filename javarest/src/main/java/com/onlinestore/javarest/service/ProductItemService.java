package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.ProductItem;
import com.onlinestore.javarest.repository.ProductItemRepository;

@Service
public class ProductItemService {

    @Autowired
    private ProductItemRepository productItemRepository;

    public List<ProductItem> getAllProductItems() {
        return (List<ProductItem>) productItemRepository.findAll();
    }
}