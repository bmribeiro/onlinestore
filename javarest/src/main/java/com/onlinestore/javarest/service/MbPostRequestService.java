package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.MbPostRequest;
import com.onlinestore.javarest.repository.MbPostRequestRepository;

@Service
public class MbPostRequestService {

    @Autowired
    private MbPostRequestRepository mbPostRequestRepository;

    public List<MbPostRequest> getAllMbPostRequests() {
        return (List<MbPostRequest>) mbPostRequestRepository.findAll();
    }

}