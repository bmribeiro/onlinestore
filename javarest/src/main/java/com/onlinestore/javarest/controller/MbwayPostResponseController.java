package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.MbwayPostResponse;
import com.onlinestore.javarest.service.MbwayPostResponseService;

@RestController
@RequestMapping("/api/mbway-post-responses")
public class MbwayPostResponseController {

	@Autowired
	private MbwayPostResponseService mbwayPostResponseService;

	@GetMapping
	public List<MbwayPostResponse> getAllMbwayPostResponses() {
		return mbwayPostResponseService.getAllMbwayPostResponses();
	}

}