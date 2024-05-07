package com.onlinestore.javarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.javarest.entities.OrderLine;
import com.onlinestore.javarest.service.OrderLineService;

@RestController
@RequestMapping("/api/order-lines")
public class OrderLineController {

    @Autowired
    private OrderLineService orderLineService;

    @GetMapping
    public List<OrderLine> getAllOrderLines() {
        return orderLineService.getAllOrderLines();
    }

}