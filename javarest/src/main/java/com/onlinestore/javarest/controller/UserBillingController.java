package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.UserBilling;
import com.onlinestore.javarest.service.UserBillingService;

@RestController
@RequestMapping("/api/user-billings")
public class UserBillingController {

	@Autowired
	private UserBillingService userBillingService;

	@GetMapping
	public List<UserBilling> getAllUserBillings() {
		return userBillingService.getAllUserBillings();
	}
}