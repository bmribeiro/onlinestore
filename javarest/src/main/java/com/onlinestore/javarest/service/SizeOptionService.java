package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.SizeOption;
import com.onlinestore.javarest.repository.SizeOptionRepository;

@Service
public class SizeOptionService {

    @Autowired
    private SizeOptionRepository sizeOptionRepository;

    public List<SizeOption> getAllSizeOptions() {
        return (List<SizeOption>) sizeOptionRepository.findAll();
    }
}