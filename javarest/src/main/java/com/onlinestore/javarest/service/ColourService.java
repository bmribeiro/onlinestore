package com.onlinestore.javarest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.Colour;
import com.onlinestore.javarest.repository.ColourRepository;

import jakarta.transaction.Transactional;

@Service
public class ColourService {

    @Autowired
    private ColourRepository colourRepository;

    public List<Colour> getAllColours() {
        return (List<Colour>) colourRepository.findAll();
    }
    
    public Optional<Colour> getColourById(Long colourId) {
		return colourRepository.findById(colourId.intValue());
	}
    
    public Colour addColour(Colour colourEntity) {
		return colourRepository.save(colourEntity);
	}
    
    public Colour updateColour(Colour colourEntity) {
		return colourRepository.save(colourEntity);
	}

	@Transactional
	public void deleteColourById(Long colourId) {
		colourRepository.deleteById(colourId.intValue());
	}
}