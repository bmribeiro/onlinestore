package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.AttributeOption;
import com.onlinestore.javarest.repository.AttributeOptionRepository;

@Service
public class AttributeOptionService {

	@Autowired
	private AttributeOptionRepository attributeOptionRepository;

	public List<AttributeOption> getAllAttributeOptions() {
		return (List<AttributeOption>) attributeOptionRepository.findAll();
	}

	public AttributeOption addAttributeOption(AttributeOption attributeOptionEntity) {
		return attributeOptionRepository.save(attributeOptionEntity);
	}
}