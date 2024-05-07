package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.ShopOrder;
import com.onlinestore.javarest.service.ShopOrderService;

@RestController
@RequestMapping("/api/shop-orders")
public class ShopOrderController {

	@Autowired
	private ShopOrderService shopOrderService;

	@GetMapping
	public List<ShopOrder> getAllShopOrders() {
		return shopOrderService.getAllShopOrders();
	}

}