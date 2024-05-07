package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.OrderLine;
import com.onlinestore.javarest.repository.OrderLineRepository;

@Service
public class OrderLineService {

	@Autowired
	private OrderLineRepository orderLineRepository;

	public List<OrderLine> getAllOrderLines() {
		return (List<OrderLine>) orderLineRepository.findAll();
	}

}