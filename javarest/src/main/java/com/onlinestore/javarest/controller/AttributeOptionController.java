package com.onlinestore.javarest.controller;

import java.io.IOException;
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

import com.onlinestore.javarest.entities.AttributeOption;
import com.onlinestore.javarest.service.AttributeOptionService;

@RestController
@RequestMapping("/api/attribute-options")
public class AttributeOptionController {

	@Autowired
	private AttributeOptionService attributeOptionService;

	@GetMapping
	public List<AttributeOption> getAllAttributeOptions() {
		return attributeOptionService.getAllAttributeOptions();
	}

	@GetMapping(path = "/{id}")
	public Optional<AttributeOption> getAttributeOptionById(@PathVariable Long id) {
		return attributeOptionService.getAttributeOptionById(id);
	}

	@PostMapping
	public ResponseEntity<AttributeOption> createAttributeOption(@RequestBody AttributeOption attributeOption) {
		AttributeOption savedAttributeOption = attributeOptionService.addAttributeOption(attributeOption);
		return new ResponseEntity<>(savedAttributeOption, HttpStatus.CREATED);
	}

	@PutMapping()
	public AttributeOption updateAttributeOption(@RequestBody AttributeOption attributeOption) {
		return attributeOptionService.updateAttributeOption(attributeOption);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteAttributeOptionById(@PathVariable Long id) {
		attributeOptionService.deleteAttributeOptionById(id);
		return ResponseEntity.ok().build();
	}

	/**
	 * Reports
	 */

	@GetMapping(path = "/excel", produces = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
	public ResponseEntity<byte[]> getAttributeOptionsExcel() throws IOException {
		return attributeOptionService.getAttributeOptionsExcel();
	}

	@GetMapping(path = "/pdf", produces = "application/pdf")
	public byte[] getAttributeOptionsPdf() throws IOException {
		return attributeOptionService.getAttributeOptionsPdf();
	}
}