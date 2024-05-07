package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.ProductVariation;

@Repository
public interface ProductVariationRepository extends CrudRepository<ProductVariation, Integer> {
}