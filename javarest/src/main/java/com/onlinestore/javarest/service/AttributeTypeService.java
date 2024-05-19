package com.onlinestore.javarest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.AttributeType;
import com.onlinestore.javarest.repository.AttributeTypeRepository;

import jakarta.transaction.Transactional;

@Service
public class AttributeTypeService {

	@Autowired
	private AttributeTypeRepository attributeTypeRepository;

	public List<AttributeType> getAllAttributeTypes() {
		return (List<AttributeType>) attributeTypeRepository.findAll();
	}

	public Optional<AttributeType> getAttributeTypeById(Long attributeTypeId) {
		return attributeTypeRepository.findById(attributeTypeId.intValue());
	}

	public AttributeType addAttributeType(AttributeType attributeTypeEntity) {
		return attributeTypeRepository.save(attributeTypeEntity);
	}

	public AttributeType updateAttributeType(AttributeType attributeTypeEntity) {
		return attributeTypeRepository.save(attributeTypeEntity);
	}

	@Transactional
	public void deleteAttributeTypeById(Long attributeTypeId) {
		attributeTypeRepository.deleteById(attributeTypeId.intValue());
	}
}