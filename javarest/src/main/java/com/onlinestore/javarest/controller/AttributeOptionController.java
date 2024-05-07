package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}