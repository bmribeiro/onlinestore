package com.onlinestore.javarest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.SizeOption;
import com.onlinestore.javarest.repository.SizeOptionRepository;

import jakarta.transaction.Transactional;

@Service
public class SizeOptionService {

	@Autowired
	private SizeOptionRepository sizeOptionRepository;

	public List<SizeOption> getAllSizeOptions() {
		return (List<SizeOption>) sizeOptionRepository.findAll();
	}

	public Optional<SizeOption> getSizeOptionById(Long sizeOptionId) {
		return sizeOptionRepository.findById(sizeOptionId.intValue());
	}

	public SizeOption addSizeOption(SizeOption sizeOption) {
		return sizeOptionRepository.save(sizeOption);
	}

	public SizeOption updateSizeOption(SizeOption sizeOption) {
		return sizeOptionRepository.save(sizeOption);
	}

	@Transactional
	public void deleteSizeOptionById(Long attributeOptionId) {
		sizeOptionRepository.deleteById(attributeOptionId.intValue());
	}
}