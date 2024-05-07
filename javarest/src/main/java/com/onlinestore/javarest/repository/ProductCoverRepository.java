package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.ProductCover;

@Repository
public interface ProductCoverRepository extends CrudRepository<ProductCover, Integer> {
}