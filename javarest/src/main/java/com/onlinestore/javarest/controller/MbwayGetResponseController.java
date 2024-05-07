package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.MbwayGetResponse;
import com.onlinestore.javarest.service.MbwayGetResponseService;

@RestController
@RequestMapping("/api/mbway-get-responses")
public class MbwayGetResponseController {

    @Autowired
    private MbwayGetResponseService mbwayGetResponseService;

    @GetMapping
    public List<MbwayGetResponse> getAllMbwayGetResponses() {
        return mbwayGetResponseService.getAllMbwayGetResponses();
    }

}