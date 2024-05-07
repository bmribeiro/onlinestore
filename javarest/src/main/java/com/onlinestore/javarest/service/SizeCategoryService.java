package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.SizeCategory;
import com.onlinestore.javarest.repository.SizeCategoryRepository;

@Service
public class SizeCategoryService {

    @Autowired
    private SizeCategoryRepository sizeCategoryRepository;

    public List<SizeCategory> getAllSizeCategories() {
        return (List<SizeCategory>) sizeCategoryRepository.findAll();
    }
}