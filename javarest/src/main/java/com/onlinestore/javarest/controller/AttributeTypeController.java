package com.onlinestore.javarest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.AttributeType;
import com.onlinestore.javarest.service.AttributeTypeService;

@RestController
@RequestMapping("/api/attribute-types")
public class AttributeTypeController {

    @Autowired
    private AttributeTypeService attributeTypeService;

    @GetMapping
    public List<AttributeType> getAllAttributeTypes() {
        return attributeTypeService.getAllAttributeTypes();
    }

    @GetMapping(path = "/{id}")
	public Optional<AttributeType> getAttributeTypeById(@PathVariable Long id) {
		return attributeTypeService.getAttributeTypeById(id);
	}
    
    @PostMapping
    public ResponseEntity<AttributeType> createAttributeType(@RequestBody AttributeType attributeType) {
    	AttributeType savedAttributeType = attributeTypeService.addAttributeType(attributeType);
        return new ResponseEntity<>(savedAttributeType, HttpStatus.CREATED);
    }
    
    @PutMapping()
	public AttributeType updateAttributeType(@RequestBody AttributeType attributeType) {
		return attributeTypeService.updateAttributeType(attributeType);
	}
    
    @DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteAttributeTypeById(@PathVariable Long id) {
    	attributeTypeService.deleteAttributeTypeById(id);
		return ResponseEntity.ok().build();
	}
}