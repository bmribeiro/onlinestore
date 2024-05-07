package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.OrderLine;

@Repository
public interface OrderLineRepository extends CrudRepository<OrderLine, Integer> {
}