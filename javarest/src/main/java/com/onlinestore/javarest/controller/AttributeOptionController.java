package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.AttributeOption;
import com.onlinestore.javarest.service.AttributeOptionService;

@RestController
@RequestMapping("/api/attribute-options")
public class AttributeOptionController {

    @Autowired
    private AttributeOptionService attributeOptionService;

    @GetMapping
    public List<AttributeOption> getAllAttributeOptions() {
        return attributeOptionService.getAllAttributeOptions();
    }
    
    @PostMapping
    public ResponseEntity<AttributeOption> createBrand(@RequestBody AttributeOption attributeOption) {
    	AttributeOption savedAttributeOption = attributeOptionService.addAttributeOption(attributeOption);
        return new ResponseEntity<>(savedAttributeOption, HttpStatus.CREATED);
    }
}