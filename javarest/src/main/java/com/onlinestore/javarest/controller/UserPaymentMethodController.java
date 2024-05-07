package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.UserPaymentMethod;
import com.onlinestore.javarest.service.UserPaymentMethodService;

@RestController
@RequestMapping("/api/user-payment-methods")
public class UserPaymentMethodController {

	@Autowired
	private UserPaymentMethodService userPaymentMethodService;

	@GetMapping
	public List<UserPaymentMethod> getAllUserPaymentMethods() {
		return userPaymentMethodService.getAllUserPaymentMethods();
	}

}