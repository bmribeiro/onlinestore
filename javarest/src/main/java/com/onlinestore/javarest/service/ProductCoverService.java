package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.ProductCover;
import com.onlinestore.javarest.repository.ProductCoverRepository;

@Service
public class ProductCoverService {

    @Autowired
    private ProductCoverRepository productCoverRepository;

    public List<ProductCover> getAllProductCovers() {
        return (List<ProductCover>) productCoverRepository.findAll();
    }

}