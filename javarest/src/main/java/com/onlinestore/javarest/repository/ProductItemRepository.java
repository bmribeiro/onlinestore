package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.ProductItem;

@Repository
public interface ProductItemRepository extends CrudRepository<ProductItem, Integer> {
}