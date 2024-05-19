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

import com.onlinestore.javarest.entities.SizeOption;
import com.onlinestore.javarest.service.SizeOptionService;

@RestController
@RequestMapping("/api/size-options")
public class SizeOptionController {

	@Autowired
	private SizeOptionService sizeOptionService;

	@GetMapping
	public List<SizeOption> getAllSizeOptions() {
		return sizeOptionService.getAllSizeOptions();
	}

	@GetMapping(path = "/{id}")
	public Optional<SizeOption> getSizeOptionById(@PathVariable Long id) {
		return sizeOptionService.getSizeOptionById(id);
	}

	@PostMapping
	public ResponseEntity<SizeOption> createAttributeOption(@RequestBody SizeOption sizeOption) {
		SizeOption savedSizeOption = sizeOptionService.addSizeOption(sizeOption);
		return new ResponseEntity<>(savedSizeOption, HttpStatus.CREATED);
	}

	@PutMapping()
	public SizeOption updateSizeOption(@RequestBody SizeOption sizeOption) {
		return sizeOptionService.updateSizeOption(sizeOption);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteSizeOptionById(@PathVariable Long id) {
		sizeOptionService.deleteSizeOptionById(id);
		return ResponseEntity.ok().build();
	}
}
