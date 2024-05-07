package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.OrderStatus;
import com.onlinestore.javarest.repository.OrderStatusRepository;

@Service
public class OrderStatusService {

	@Autowired
	private OrderStatusRepository orderStatusRepository;

	public List<OrderStatus> getAllOrderStatuses() {
		return (List<OrderStatus>) orderStatusRepository.findAll();
	}

}