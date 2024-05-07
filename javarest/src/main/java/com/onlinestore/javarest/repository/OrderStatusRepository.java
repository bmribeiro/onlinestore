package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.OrderStatus;

@Repository
public interface OrderStatusRepository extends CrudRepository<OrderStatus, Integer> {
}
