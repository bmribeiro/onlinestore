package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.ShippingMethod;
import com.onlinestore.javarest.repository.ShippingMethodRepository;

@Service
public class ShippingMethodService {

	@Autowired
	private ShippingMethodRepository shippingMethodRepository;

	public List<ShippingMethod> getAllShippingMethods() {
		return (List<ShippingMethod>) shippingMethodRepository.findAll();
	}

}
