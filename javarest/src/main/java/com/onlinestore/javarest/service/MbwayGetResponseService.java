package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.MbwayGetResponse;
import com.onlinestore.javarest.repository.MbwayGetResponseRepository;

@Service
public class MbwayGetResponseService {

    @Autowired
    private MbwayGetResponseRepository mbwayGetResponseRepository;

    public List<MbwayGetResponse> getAllMbwayGetResponses() {
        return (List<MbwayGetResponse>) mbwayGetResponseRepository.findAll();
    }

}