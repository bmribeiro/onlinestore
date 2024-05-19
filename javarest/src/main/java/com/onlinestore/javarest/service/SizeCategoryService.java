package com.onlinestore.javarest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.SizeCategory;
import com.onlinestore.javarest.repository.SizeCategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class SizeCategoryService {

	@Autowired
	private SizeCategoryRepository sizeCategoryRepository;

	public List<SizeCategory> getAllSizeCategories() {
		return (List<SizeCategory>) sizeCategoryRepository.findAll();
	}

	public Optional<SizeCategory> getSizeCategoryById(Long sizeCategoryId) {
		return sizeCategoryRepository.findById(sizeCategoryId.intValue());
	}

	public SizeCategory addSizeCategory(SizeCategory sizeCategoryEntity) {
		return sizeCategoryRepository.save(sizeCategoryEntity);
	}

	public SizeCategory updateSizeCategory(SizeCategory sizeCategory) {
		return sizeCategoryRepository.save(sizeCategory);
	}

	@Transactional
	public void deleteSizeCategoryById(Long sizeCategoryId) {
		sizeCategoryRepository.deleteById(sizeCategoryId.intValue());
	}

}