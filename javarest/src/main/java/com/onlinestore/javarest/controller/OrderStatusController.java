package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.OrderStatus;
import com.onlinestore.javarest.service.OrderStatusService;

@RestController
@RequestMapping("/api/order-statuses")
public class OrderStatusController {

    @Autowired
    private OrderStatusService orderStatusService;

    @GetMapping
    public List<OrderStatus> getAllOrderStatuses() {
        return orderStatusService.getAllOrderStatuses();
    }

}
