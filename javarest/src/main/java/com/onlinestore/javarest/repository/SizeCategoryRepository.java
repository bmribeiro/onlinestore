package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.SizeCategory;

@Repository
public interface SizeCategoryRepository extends CrudRepository<SizeCategory, Integer> {

}	