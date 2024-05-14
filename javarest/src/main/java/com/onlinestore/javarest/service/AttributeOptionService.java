package com.onlinestore.javarest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.AttributeOption;
import com.onlinestore.javarest.repository.AttributeOptionRepository;

import jakarta.transaction.Transactional;

@Service
public class AttributeOptionService {

	@Autowired
	private AttributeOptionRepository attributeOptionRepository;

	public List<AttributeOption> getAllAttributeOptions() {
		return (List<AttributeOption>) attributeOptionRepository.findAll();
	}

	public Optional<AttributeOption> getAttributeOptionById(Long attributeOptionId) {
		return attributeOptionRepository.findById(attributeOptionId.intValue());
	}

	public AttributeOption addAttributeOption(AttributeOption attributeOptionEntity) {
		return attributeOptionRepository.save(attributeOptionEntity);
	}

	public AttributeOption updateAttributeOption(AttributeOption attributeOptionEntity) {
		return attributeOptionRepository.save(attributeOptionEntity);
	}

	@Transactional
	public void deleteAttributeOptionById(Long attributeOptionId) {
		attributeOptionRepository.deleteById(attributeOptionId.intValue());
	}
}