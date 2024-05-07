package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.Colour;
import com.onlinestore.javarest.repository.ColourRepository;

@Service
public class ColourService {

    @Autowired
    private ColourRepository colourRepository;

    public List<Colour> getAllColours() {
        return (List<Colour>) colourRepository.findAll();
    }
}