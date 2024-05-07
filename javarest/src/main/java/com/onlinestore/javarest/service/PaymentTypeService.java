package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.PaymentType;
import com.onlinestore.javarest.repository.PaymentTypeRepository;

@Service
public class PaymentTypeService {

	@Autowired
	private PaymentTypeRepository paymentTypeRepository;

	public List<PaymentType> getAllPaymentTypes() {
		return (List<PaymentType>) paymentTypeRepository.findAll();
	}

}