package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.UserRole;
import com.onlinestore.javarest.service.UserRoleService;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;

	@GetMapping
	public List<UserRole> getAllUserRoles() {
		return userRoleService.getAllUserRoles();
	}

}