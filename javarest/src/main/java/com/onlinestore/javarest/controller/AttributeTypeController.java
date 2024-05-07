package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}