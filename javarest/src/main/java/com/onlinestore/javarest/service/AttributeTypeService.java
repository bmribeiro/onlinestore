package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.AttributeType;
import com.onlinestore.javarest.repository.AttributeTypeRepository;

@Service
public class AttributeTypeService {

    @Autowired
    private AttributeTypeRepository attributeTypeRepository;

    public List<AttributeType> getAllAttributeTypes() {
        return (List<AttributeType>) attributeTypeRepository.findAll();
    }
}