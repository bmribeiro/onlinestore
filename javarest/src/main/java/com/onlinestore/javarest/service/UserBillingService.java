package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.UserBilling;
import com.onlinestore.javarest.repository.UserBillingRepository;

@Service
public class UserBillingService {

	@Autowired
	private UserBillingRepository userBillingRepository;

	public List<UserBilling> getAllUserBillings() {
		return (List<UserBilling>) userBillingRepository.findAll();
	}

}
