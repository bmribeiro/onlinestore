package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.MbPostRequest;
import com.onlinestore.javarest.service.MbPostRequestService;

@RestController
@RequestMapping("/api/mb-post-requests")
public class MbPostRequestController {

    @Autowired
    private MbPostRequestService mbPostRequestService;

    @GetMapping
    public List<MbPostRequest> getAllMbPostRequests() {
        return mbPostRequestService.getAllMbPostRequests();
    }

}