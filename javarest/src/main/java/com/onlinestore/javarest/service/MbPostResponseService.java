package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.MbPostResponse;
import com.onlinestore.javarest.repository.MbPostResponseRepository;

@Service
public class MbPostResponseService {

    @Autowired
    private MbPostResponseRepository mbPostResponseRepository;

    public List<MbPostResponse> getAllMbPostResponses() {
        return (List<MbPostResponse>) mbPostResponseRepository.findAll();
    }

}