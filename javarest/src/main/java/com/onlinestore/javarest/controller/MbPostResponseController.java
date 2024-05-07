package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.MbPostResponse;
import com.onlinestore.javarest.service.MbPostResponseService;

@RestController
@RequestMapping("/api/mb-post-responses")
public class MbPostResponseController {

    @Autowired
    private MbPostResponseService mbPostResponseService;

    @GetMapping
    public List<MbPostResponse> getAllMbPostResponses() {
        return mbPostResponseService.getAllMbPostResponses();
    }

}