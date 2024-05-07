package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.SizeOption;
import com.onlinestore.javarest.service.SizeOptionService;

@RestController
@RequestMapping("/api/size-options")
public class SizeOptionController {

    @Autowired
    private SizeOptionService sizeOptionService;

    @GetMapping
    public List<SizeOption> getAllSizeOptions() {
        return sizeOptionService.getAllSizeOptions();
    }
}
