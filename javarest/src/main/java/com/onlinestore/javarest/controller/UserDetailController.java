package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.UserDetail;
import com.onlinestore.javarest.service.UserDetailService;

@RestController
@RequestMapping("/api/user-details")
public class UserDetailController {

	@Autowired
	private UserDetailService userDetailService;

	@GetMapping
	public List<UserDetail> getAllUserDetails() {
		return userDetailService.getAllUserDetail();
	}
}