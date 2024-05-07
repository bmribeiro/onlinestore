package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.UserPaymentPhone;
import com.onlinestore.javarest.repository.UserPaymentPhoneRepository;

@Service
public class UserPaymentPhoneService {

	@Autowired
	private UserPaymentPhoneRepository userPaymentPhoneRepository;

	public List<UserPaymentPhone> getAllUserPaymentPhones() {
		return (List<UserPaymentPhone>) userPaymentPhoneRepository.findAll();
	}
}