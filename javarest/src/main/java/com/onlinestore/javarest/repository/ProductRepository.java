package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
