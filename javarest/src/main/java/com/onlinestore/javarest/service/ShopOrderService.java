package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.ShopOrder;
import com.onlinestore.javarest.repository.ShopOrderRepository;

@Service
public class ShopOrderService {

	@Autowired
	private ShopOrderRepository shopOrderRepository;

	public List<ShopOrder> getAllShopOrders() {
		return (List<ShopOrder>) shopOrderRepository.findAll();
	}

}