package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.ProductAttribute;

@Repository
public interface ProductAttributeRepository extends CrudRepository<ProductAttribute, Integer> {
}