package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.Brand;
import com.onlinestore.javarest.entities.Colour;
import com.onlinestore.javarest.service.ColourService;

@RestController
@RequestMapping("/api/colours") 
public class ColourController {

	@Autowired
	private ColourService colourService;

	@GetMapping
	public List<Colour> getAllColours() {
		return colourService.getAllColours();
	}
	
	@PostMapping
    public ResponseEntity<Colour> createColour(@RequestBody Colour colour) {
		Colour savedColour = colourService.addColour(colour);
        return new ResponseEntity<>(savedColour, HttpStatus.CREATED);
    }
	
}
