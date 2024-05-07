package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.MbwayPostResponse;
import com.onlinestore.javarest.repository.MbwayPostResponseRepository;

@Service
public class MbwayPostResponseService {

	@Autowired
	private MbwayPostResponseRepository mbwayPostResponseRepository;

	public List<MbwayPostResponse> getAllMbwayPostResponses() {
		return (List<MbwayPostResponse>) mbwayPostResponseRepository.findAll();
	}

}