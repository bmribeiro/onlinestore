package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.ShippingMethod;

@Repository
public interface ShippingMethodRepository extends CrudRepository<ShippingMethod, Integer> {
}