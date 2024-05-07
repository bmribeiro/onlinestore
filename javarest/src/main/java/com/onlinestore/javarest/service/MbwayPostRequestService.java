package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.MbwayPostRequest;
import com.onlinestore.javarest.repository.MbwayPostRequestRepository;

@Service
public class MbwayPostRequestService {

    @Autowired
    private MbwayPostRequestRepository mbwayPostRequestRepository;

    public List<MbwayPostRequest> getAllMbwayPostRequests() {
        return (List<MbwayPostRequest>) mbwayPostRequestRepository.findAll();
    }

}