package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.MbwayPostRequest;
import com.onlinestore.javarest.service.MbwayPostRequestService;

@RestController
@RequestMapping("/api/mbway-post-requests")
public class MbwayPostRequestController {

    @Autowired
    private MbwayPostRequestService mbwayPostRequestService;

    @GetMapping
    public List<MbwayPostRequest> getAllMbwayPostRequests() {
        return mbwayPostRequestService.getAllMbwayPostRequests();
    }

}