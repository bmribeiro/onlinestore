package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.Brand;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer> {
}