package com.onlinestore.javarest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping(path = "/{id}")
	public Optional<Colour> getAttributeOptionById(@PathVariable Long id) {
		return colourService.getColourById(id);
	}
	
	@PostMapping
    public ResponseEntity<Colour> createColour(@RequestBody Colour colour) {
		Colour savedColour = colourService.addColour(colour);
        return new ResponseEntity<>(savedColour, HttpStatus.CREATED);
    }
	
	@PutMapping()
	public Colour updateAttributeOption(@RequestBody Colour colour) {
		return colourService.updateColour(colour);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteAttributeOptionById(@PathVariable Long id) {
		colourService.deleteColourById(id);
		return ResponseEntity.ok().build();
	}
	
}
